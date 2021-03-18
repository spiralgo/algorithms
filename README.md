Not: LeetCode'da en son submit edilmiş kodu geri yükleyebiliyorsun. Sağ üstte bunun için bir button var.


[582. Kill Process:](https://github.com/altayhunoglu/algorithms/issues/10)

Daha önce öğrendiklerimize dayanarak "Approach #3 HashMap + Depth First Search" çözümünün, bizim düşünce şeklimize daha uygun olduğu kanaatindeyim.
LeetCode üzerindeki video izlenip konu çalışılmalı.

[1120. Maximum Average Subtree](https://github.com/altayhunoglu/algorithms/issues/12)

LeetCode'da bunun için önerilen "Approach 1: Postorder Traversal", bana göre de uygundur. 

Zirâ, post-order'da root en son hesaplanır.
 
 Bu yüzden alttaki yavruların ortalamasını hesaplarken yukarı doğru çıktığı için, onları hesaplarken elde ettiği verileri üst-node'lar için de aynı şekilde kullanabileceği için tekrâr hesap yapmasına gerek kalmaz.
 


[370. Range Addition](https://github.com/altayhunoglu/algorithms/issues/13)

En yüksek puanı almış olan çözüm, bana kalırsa da uygundur:
https://leetcode.com/problems/range-addition/discuss/84217/Java-O(K-%2B-N)time-complexity-Solution

Buradaki çözümü tam olarak kavrayıp, bu notu geliştireceğiz.
 Ama şimdilik verdiği örnekten anladığım kadarı ile, indeks aralığındaki tüm rakamlara o anki operasyonu uygulamak yerine, sâdece ilk indexe uyguluyor ve son index'ten bir fazlasına ise sonucun negatif hâlini ekliyor. Diğer operasyon için de farklı bir sonuç arrayi (res) yaratarak aynısını yapıyor.
 Son hamlede ise, soldan sağa toplayarak sonucu elde ediyor.
 Böyle bir düşünce şekline nasıl vardığını anlamak gerek.


[1087. Brace Expansion](https://github.com/altayhunoglu/algorithms/issues/14)

Şuradaki çözüm uygun görünüyor:
https://leetcode.com/problems/brace-expansion/discuss/312361/Java-DFS

Bu çözüm vesilesi ile TreeSet veri yapısı öğrenilmeli.

[426. Convert Binary Search Tree to Sorted Doubly Linked List](https://github.com/altayhunoglu/algorithms/issues/15)

Bunu tam da düşündüğümüz gibi, Inoder rekürsif kullanarak çözmüş. Çünkü inorder zâten bir Binary Tree'ye, küçükten büyüğe sıralayarak veriyor.
Çözüm gayet akla yatkın.

[1245. Tree Diameter](https://github.com/altayhunoglu/algorithms/issues/16)

Daha önce bunun altyapısı gibi düşünülebilecek, kısmen daha kolay bir soru olan "1522. Diameter of N-Ary Tree" çözmüştük.

Bu sorudaki püf nokta, en derinden yani yapraklardan başlayarak (depth-first) hesaplama yapmaktı.

Bir yaprağın uzunluğunu sıfır olarak kabul edip, bunun üzerinden üstteki node'ların uzunluğunu hesaplıyorduk.

Diameter, ya alt node'larda çıkabilirdi veyâhud daha üst node'lardan. Hangisi uzun ise (Math.max kullanarak) onu alıyorduk.

İşte bu çözümü aynı şekilde uyguladığı için aşina olduğumuz "Approach 3: DFS (Depth-First Search)" çözümü incelenmelidir.

[1538. Guess the Majority in a Hidden Array](https://github.com/altayhunoglu/algorithms/issues/17)
Burada en çok oy alan çözümün altındaki, gözden geçirilmiş çözümü submit ettim.
İnceledikçe, buradaki notu güncelleyeceğim.

[1136. Parallel Courses](https://github.com/altayhunoglu/algorithms/issues/18)
Bu soruda Approach 1: Breadth-First Search (Kahn's Algorithm) çözümü gâyet uygun görünüyor.
 Bu vesîle ile Kahn algoritmasını da öğrenmiş olacağız.

[510. Inorder Successor in BST II](https://github.com/altayhunoglu/algorithms/issues/19)
Bu soruda, "solution" kısmında verilen "Approach 1: Iteration" gayet anlaşılır görünüyor.

[635. Design Log Storage System](https://github.com/altayhunoglu/algorithms/issues/20)
Burada "Approach #2 Better Retrieval" performans bakımından daha iyi olduğundan ve TreeMap kullanımına dair yeni bir örnek olduğundan ötürü tercih edilmeli.

[531. Lonely Pixel I ](https://github.com/altayhunoglu/algorithms/issues/21)
Bu soruda en fazla puan alan çözüm gâyet anlaşılır görünüyor. Bu çözümde, iki yöntem belirtilmiş. İkinci yöntem daha az yer kapladığı için onu seçtik.

[369. Plus One Linked List] (https://github.com/altayhunoglu/algorithms/issues/22)
Bu soruda standart çözüm gayet uygun ve anlaşılır görünüyor:
Approach 1: Sentinel Head + Textbook Addition.








 



 

