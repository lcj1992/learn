package lamda.develop;

import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/5/1
 * Time: 下午9:35
 */
public class Developer {

    private String name;
    private Set<String> languages;

    public Developer(String name) {
        this.languages = new HashSet<>();
        this.name = name;
    }

    public void add(String language) {
        this.languages.add(language);
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public static void main(String[] args) {
        List<Developer> team = new ArrayList<>();
        Developer polyglot = new Developer("esoteric");
        polyglot.add("clojure");
        polyglot.add("scala");
        polyglot.add("groovy");
        polyglot.add("go");

        Developer busy = new Developer("pragmatic");
        busy.add("java");
        busy.add("javascript");

        team.add(polyglot);
        team.add(busy);

        List<String> teamLanguages = team.stream().
                map(Developer::getLanguages).
                flatMap(Collection::stream).
                collect(Collectors.toList());
        System.out.println(teamLanguages);
        Assert.assertTrue(teamLanguages.containsAll(polyglot.getLanguages()));
        Assert.assertTrue(teamLanguages.containsAll(busy.getLanguages()));


        try (FileInputStream stream = new FileInputStream(new File("~/heheda"))) {
            stream.getChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
