package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class DesignInMemoryFileSystem {

    class FileSystem {

        public Directory root;

        public FileSystem() {
            root = new Directory("");
        }

        public List<String> ls(String path) {
            return findDir(path).getList();
        }

        public void mkdir(String path) {
            findDir(path);
        }

        public void addContentToFile(String filePath, String content) {
            findDir(filePath).addContent(content);
        }

        public String readContentFromFile(String filePath) {
            return findDir(filePath).getContent();
        }

        private Directory findDir(String path) {
            String[] files = path.split("/");
            Directory cur = root;

            for (String file : files) {
                if (file.length() == 0)
                    continue;
                cur.subDirs.putIfAbsent(file, new Directory(file));
                cur = cur.subDirs.get(file);
                if (cur.isFile())
                    break;
            }
            
            return cur;
        }

        private class Directory {
            public TreeMap<String, Directory> subDirs;
            private StringBuilder fileContent;
            private String name;

            public Directory(String name) {
                subDirs = new TreeMap<>();
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public String getContent() {
                return fileContent.toString();
            }

            public void addContent(String content) {
                if (fileContent == null) {
                    fileContent = new StringBuilder();
                }
                fileContent.append(content);
            }

            public boolean isFile() {
                return fileContent != null;
            }

            public List<String> getList() {
                List<String> list = new ArrayList<>();
                if (isFile())
                    list.add(getName());
                else
                    list.addAll(subDirs.keySet());
                return list;
            }

        }

    }
}