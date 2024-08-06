package lamda.develop;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2017/5/1
 * Time: 下午9:35
 */
public class Developer {

    private Set<String> languages;

    public Developer() {
        this.languages = new HashSet<>();
    }

    public void add(String language) {
        this.languages.add(language);
    }

    public Set<String> getLanguages() {
        return languages;
    }

    @Test
    public void test(){
        List<Developer> team = new ArrayList<>();
        Developer polyglot = new Developer();
        polyglot.add("clojure");
        polyglot.add("scala");
        polyglot.add("groovy");
        polyglot.add("go");

        Developer busy = new Developer();
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
