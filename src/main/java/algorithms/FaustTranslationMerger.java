package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FaustTranslationMerger implements MergeStringLineByLineInterface{

    public static void main(String[] args) {
        String text1 = "MÜDÜR\n"
                + "Siz çok kez bana\n"
                + "Zor ve sıkıntılı anlarımda yardım ettiniz,\n"
                + "Söyleyin, Alman diyarlarındaki\n"
                + "Girişimlerimizden ne beklersiniz?\n"
                + "Çok isterdim eğlendirmek bu kalabalığı,\n"
                + "Yaşadığı ve özellikle de yaşattığından dolayı,\n"
                + "Tahtalar çakıldı, direkler dikildi,\n"
                + "Ve herkes eğlence bekliyor.\n"
                + "Kaşlar kalkmış oturmuş yerine,\n"
                + "Sakin bekliyor ve hayret içinde seyretmek istiyor.\n"
                + "Bilirim ben girmeyi halkın gönlüne;\n"
                + "Ama kalmamıştım asla böyle zor bir durumda;\n"
                + "Gerçi alışık değiller böylesine iyi eserlere,\n"
                + "Fakat şurası kesin, hepsi okumuş oldukça.\n"
                + "Ne yapmalı ki, her şey yeni ve ilginç\n"
                + "Ve beğenecekleri, anlamlı bir oyun olmalı?\n"
                + "Görmek isterim kalabalığı elbette,\n"
                + "Sel gibi çadır tiyatromuza akan\n"
                + "Ve güçlü, yinelenen sancılarla\n"
                + "Dar kapıdan girmeye çalışan,\n"
                + "Gündüz vakti, saatler henüz dördü göstermeden,\n"
                + "Bilet almak için mücadele veren,\n"
                + "Sanki kıtlıkta fırının kapısında ekmek bekleyen,\n"
                + "Tek bir bilet için birbirini çiğneyen.\n"
                + "Bu mucize her tür insanı etkiler,\n"
                + "Yazardır ancak bu etkiyi yaratacak: Dostum, gerçekleştir hemen bunu!\n";

        String text2 = "MANAGER\n"
                + "You two, who oft a helping hand\n"
                + "Have lent, in need and tribulation.\n"
                + "Come, let me know your expectation\n"
                + "Of this, our enterprise, in German land!\n"
                + "I wish the crowd to feel itself well treated,\n"
                + "Especially since it lives and lets me live;\n"
                + "The posts are set, the booth of boards completed.\n"
                + "And each awaits the banquet I shall give.\n"
                + "Already there, with curious eyebrows raised,\n"
                + "They sit sedate, and hope to be amazed.\n"
                + "I know how one the People's taste may flatter,\n"
                + "Yet here a huge embarrassment I feel:\n"
                + "What they're accustomed to, is no great matter,\n"
                + "But then, alas! they've read an awful deal.\n"
                + "How shall we plan, that all be fresh and new,—\n"
                + "Important matter, yet attractive too?\n"
                + "For 'tis my pleasure-to behold them surging,\n"
                + "When to our booth the current sets apace,\n"
                + "And with tremendous, oft-repeated urging,\n"
                + "Squeeze onward through the narrow gate of grace:\n"
                + "By daylight even, they push and cram in\n"
                + "To reach the seller's box, a fighting host,\n"
                + "And as for bread, around a baker's door, in famine,\n"
                + "To get a ticket break their necks almost.\n"
                + "This miracle alone can work the Poet\n"
                + "On men so various: now, my friend, pray show it.";

        String text3 = "Director.\n"
                + "Ihr beyden die ihr mir so oft,\n"
                + "In Noth und Trübsal, beygestanden,\n"
                + "Sagt was ihr wohl, in deutschen Landen,\n"
                + "Von unsrer Unternehmung hofft?\n"
                + "Ich wünschte sehr der Menge zu behagen,\n"
                + "Besonders weil sie lebt und leben läßt.\n"
                + "Die Pfosten sind, die Breter aufgeschlagen,\n"
                + "Und jedermann erwartet sich ein Fest.\n"
                + "Sie sitzen schon, mit hohen Augenbraunen,\n"
                + "Gelassen da und möchten gern erstaunen.\n"
                + "Ich weiß wie man den Geist des Volks versöhnt;\n"
                + "Doch so verlegen bin ich nie gewesen;\n"
                + "Zwar sind sie an das Beste nicht gewöhnt,\n"
                + "[10]Allein sie haben schrecklich viel gelesen.\n"
                + "Wie machen wir’s? daß alles frisch und neu\n"
                + "Und mit Bedeutung auch gefällig sey.\n"
                + "Denn freylich mag ich gern die Menge sehen,\n"
                + "Wenn sich der Strom nach unsrer Bude drängt,\n"
                + "Und mit gewaltig wiederholten Wehen,\n"
                + "Sich durch die enge Gnadenpforte zwängt;\n"
                + "Bey hellem Tage, schon vor Vieren,\n"
                + "Mit Stößen sich bis an die Kasse ficht\n"
                + "Und, wie in Hungersnoth um Brot an Beckerthüren,\n"
                + "Um ein Billet sich fast die Hälse bricht.\n"
                + "Dieß Wunder wirkt auf so verschiedne Leute\n"
                + "Der Dichter nur; mein Freund, o! thu es heute.";

        FaustTranslationMerger mergeStringLineByLine = new FaustTranslationMerger();

        mergeStringLineByLine.addNewLanguageText(text1);
        mergeStringLineByLine.addNewLanguageText(text2);
        mergeStringLineByLine.addNewLanguageText(text3);
        String result = mergeStringLineByLine.mergeProcess();

        mergeStringLineByLine.writeResultToFile(result, "F:\\faustexcerpt.txt");

    }

    List<List<String>> languageList = new ArrayList<>();

    public String mergeProcess() {

        StringBuilder buff = new StringBuilder();

        for (int i = 0; i < languageList.get(0).size(); i++) {
            for (List<String> list : languageList) {
                buff.append(list.get(i)).append("\r\n");

            }

            buff.append("\r");
        }

        return buff.toString();
    }

  
    @Override
    public List<String> convertTextintoList(String text) {
        return new ArrayList<>(Arrays.asList(text.split("\n")));
    }

    @Override
    public void addNewLanguageText(String text) {
        languageList.add(convertTextintoList(text));
    }

    @Override
    public void writeResultToFile(String text, String path) {
        FileUtil.write(text, path);
    }
}
