package algorithms;

import java.util.List;

/**
 *
 * @author Altay
 */
public interface MergeStringLineByLineInterface {
    public String mergeProcess();

    List<String> convertTextintoList(String text);

    void addNewLanguageText(String text);

    void writeResultToFile(String text, String path);
}
