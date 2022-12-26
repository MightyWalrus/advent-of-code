package sonar_sweeping;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class SweeperFeeder {

    private String fileName;

    public SweeperFeeder(String fileName) {
        this.fileName = fileName;
    }

    public List<Integer> feed() {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        return reader.lines()
                .map(line -> Integer.valueOf(line))
                .collect(Collectors.toList());
    }

}
