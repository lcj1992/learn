package linear.skip_list;

import lombok.Data;

import java.util.Objects;
import java.util.Random;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/18
 * Time: 下午8:54
 */
@Data
public class SkipList {
    public SkipListNode head; // 顶层的第一个元素
    public SkipListNode tail; // 顶层的最后一个元素
    public int size; // 跳跃表中的元素个数
    public int height; // 跳跃表的高度
    public Random flag; // 投掷硬币

    SkipList() {
        head = new SkipListNode(SkipListNode.negInf, null);
        tail = new SkipListNode(SkipListNode.posInf, null);

        head.right = tail;
        tail.left = head;

        size = 0;
        height = 0;
        flag = new Random();
    }

    public int size() {
        return size;
    }

    private SkipListNode find(String k) {
        SkipListNode p = head;
        while (true) {
            while (!Objects.equals(p.right.key, SkipListNode.posInf) && p.right.key.compareTo(k) <= 0) {
                p = p.right;
            }
            if (p.down != null) {
                p = p.down;
            } else {
                break; // 到了最下面一层 就停止查找
            }
        }
        return p; // p.key <= k
    }

    public Integer get(String k) {
        SkipListNode p = find(k);

        if (k.equals(p.getKey())) {
            return p.value;
        } else {
            return null;
        }
    }

    public Integer put(String k, Integer v) {
        printHorizontal();
        SkipListNode p;
        SkipListNode q;
        p = find(k);

        if (k.equals(p.getKey())) {
            Integer old = p.value;
            p.value = v;
            return old;
        }

        q = new SkipListNode(k, v);
        q.left = p;
        q.right = p.right;
        p.right.left = q;
        p.right = q;

        int currentLevel = 0; // 当前层 currentLevel = 0

        // 随机值小于0.5，则插入的键值对对应的键需要在上一层建立关联，同时有可能增加跳表的高度
        while (flag.nextDouble() < 0.5) {
            // 如果超出了高度，需要重新建一个顶层
            if (currentLevel >= height) {
                SkipListNode p1, p2;
                height = height + 1;
                p1 = new SkipListNode(SkipListNode.negInf, null);
                p2 = new SkipListNode(SkipListNode.posInf, null);
                p1.right = p2;
                p1.down = head;
                p2.left = p1;
                p2.down = tail;
                head.up = p1;
                tail.up = p2;
                head = p1;
                tail = p2;
            }

            while (p.up == null) {
                p = p.left;
            }
            p = p.up;

            SkipListNode e;

            e = new SkipListNode(k, null);
            e.left = p;
            e.right = p.right;
            e.down = q;
            p.right.left = e;
            p.right = e;
            q.up = e;
            q = e; // q 进行下一层迭代
            currentLevel = currentLevel + 1; // 当前层 +1
        }
        size = size + 1;
        printHorizontal();
        return null;
    }

    public void remove(String key) {
        SkipListNode p = find(key);

        if (!p.getKey().equals(key)) {
            return;
        }

        p.left.right = p.right;
        p.right.left = p.left;
        p.right = null;
        p.left = null;
        while (p.up != null) {
            p = p.up;
            p.left.right = p.right;
            p.right.left = p.left;
            p.right = null;
            p.left = null;
        }

        while (p.down != null) {
            SkipListNode temp = p.down;
            p.down = null;
            temp.up = null;
            p = temp;
        }

        while (Objects.equals(head.right.key, tail.key) && height > 0) {
            SkipListNode p1, p2;
            p1 = head.down;
            p2 = tail.down;

            head.right = null;
            head.down = null;

            tail.left = null;
            tail.down = null;

            p1.up = null;
            p2.up = null;
            head = p1;
            tail = p2;
            height = height - 1;
        }
        size = size - 1;
        printHorizontal();
    }

    private void printHorizontal() {
        String s = "";
        int i;
        SkipListNode p;

        p = head;

        while (p.down != null) {
            p = p.down;
        }

        i = 0;
        while (p != null) {
            p.pos = i++;
            p = p.right;
        }

        p = head;
        while (p != null) {
            s = getOneRow(p);
            System.out.println(s);
            p = p.down;
        }
    }

    private String getOneRow(SkipListNode p) {
        StringBuilder s;
        int a, b, i;
        a = 0;
        s = new StringBuilder("" + p.key);
        p = p.right;
        while (p != null) {
            SkipListNode q;
            q = p;
            while (q.down != null)
                q = q.down;
            b = q.pos;
            s.append(" <-");
            for (i = a + 1; i < b; i++) {
                s.append("--------");
            }
            s.append("> ").append(p.key);
            a = b;
            p = p.right;
        }
        return s.toString();
    }

}

class SkipListNode {
    String key;
    Integer value;

    int pos;

    SkipListNode up, down, left, right; // 上下左右 四个指针

    static String negInf = "-oo"; // 负无穷
    static String posInf = "+oo"; // 正无穷

    SkipListNode(String k, Integer v) {
        key = k;
        value = v;
        up = down = left = right = null;
    }

    private Integer getValue() {
        return value;
    }

    String getKey() {
        return key;
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        SkipListNode entry;
        try {
            entry = (SkipListNode) o; // 检测类型
        } catch (ClassCastException ex) {
            return false;
        }
        return (Objects.equals(entry.getKey(), key)) && (entry.getValue().equals(value));
    }

    public String toString() {
        return "(" + key + "," + value + ")";
    }
}
