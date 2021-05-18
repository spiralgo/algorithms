Welcome to our spiral!

We voluntarily solve algorithm problems on this repo that we call Spiralgo.

We will translate the solutions into many languages including Turkish, Korean, German.

You are more than welcome to join us.

![Welcome to our spiral!](https://avatars.githubusercontent.com/u/82793840?v=4)


 

[442. Find All Duplicates in an Array](https://github.com/spiralgo/algorithms/issues/98)

Açıklaması issue içindedir.

[200. Number of Islands](https://github.com/spiralgo/algorithms/issues/97)

Açıklaması issue içindedir.

[5. Longest Palindromic Substring](https://github.com/spiralgo/algorithms/issues/96)

Açıklaması issue içindedir.

[207. Closest Binary Search Tree Value](https://github.com/spiralgo/algorithms/issues/95)

Açıklaması issue içindedir.

[204. Count Primes](https://github.com/spiralgo/algorithms/issues/94)

Açıklaması issue içindedir.

[Inverse Square Root Algorithm](https://github.com/spiralgo/algorithms/issues/1)
 
[Subset Sum Problem](https://github.com/spiralgo/algorithms/pull/102)

[Using the Monte Carlo Method to estimate Pi](https://github.com/spiralgo/algorithms/pull/103)
 
[Knapsack, Weighted Interval Scheduling Naive solutions ](https://github.com/spiralgo/algorithms/pull/100)

[0/1 Knapsack](https://github.com/spiralgo/algorithms/pull/105)


**CURATED 170 SORULARI:**

**EASY:**


  [🔶 LeetCode Curated Algo 170 EASY (Türkçe):](https://github.com/spiralgo/algorithms/wiki/%F0%9F%94%B6-LeetCode-Curated-Algo-170---EASY-(T%C3%BCrk%C3%A7e)) 

**MEDUIM:**

[1265. Print Immutable Linked List in Reverse:](https://github.com/spiralgo/algorithms/issues/255)

[1490. Clone N-ary Tree:](https://github.com/spiralgo/algorithms/issues/256)

[1506. Find Root of N-Ary Tree:](https://github.com/spiralgo/algorithms/issues/257)

[1198. Find Smallest Common Element in All Rows:](https://github.com/spiralgo/algorithms/issues/261)

[723. Candy Crush:](https://github.com/spiralgo/algorithms/issues/262)

[1100. Find K-Length Substrings With No Repeated Characters:](https://github.com/spiralgo/algorithms/issues/264)

[366. Find Leaves of Binary Tree :](https://github.com/spiralgo/algorithms/issues/266)

[1522. Diameter of N-Ary Tree #174:](https://github.com/spiralgo/algorithms/issues/174)

[1101. The Earliest Moment When Everyone Become Friends:](https://github.com/spiralgo/algorithms/issues/185)

[1061. Lexicographically Smallest Equivalent String:](https://github.com/spiralgo/algorithms/issues/186)

[ 1244. Design A Leaderboard:](https://github.com/spiralgo/algorithms/issues/2)

[1564. Put Boxes Into the Warehouse I:](https://github.com/spiralgo/algorithms/issues/3)

[ 362. Design Hit Counter:](https://github.com/spiralgo/algorithms/issues/4)

[280. Wiggle Sort:](https://github.com/spiralgo/algorithms/issues/5)

[1236. Web Crawler:](https://github.com/spiralgo/algorithms/issues/6)

[1167. Minimum Cost to Connect Sticks:](https://github.com/spiralgo/algorithms/issues/7)

[484. Find Permutation:](https://github.com/spiralgo/algorithms/issues/8)

[311. Sparse Matrix Multiplication:](https://github.com/spiralgo/algorithms/issues/9)

[364. Nested List Weight Sum II:](https://github.com/spiralgo/algorithms/issues/11)


[582. Kill Process:](https://github.com/spiralgo/algorithms/issues/10)

Daha önce öğrendiklerimize dayanarak "Approach #3 HashMap + Depth First Search" çözümünün, bizim düşünce şeklimize daha uygun olduğu kanaatindeyim.
LeetCode üzerindeki video izlenip konu çalışılmalı.

[1120. Maximum Average Subtree](https://github.com/spiralgo/algorithms/issues/12)

LeetCode'da bunun için önerilen "Approach 1: Postorder Traversal", bana göre de uygundur. 

Zirâ, post-order'da root en son hesaplanır.
 
 Bu yüzden alttaki yavruların ortalamasını hesaplarken yukarı doğru çıktığı için, onları hesaplarken elde ettiği verileri üst-node'lar için de aynı şekilde kullanabileceği için tekrâr hesap yapmasına gerek kalmaz.
 


[370. Range Addition](https://github.com/spiralgo/algorithms/issues/13)

En yüksek puanı almış olan çözüm, bana kalırsa da uygundur:
https://leetcode.com/problems/range-addition/discuss/84217/Java-O(K-%2B-N)time-complexity-Solution

 Aslında anlayınca çok basit.
 startIndex'i ve endIndex'i, bir tür işâretleme olarak kullanıyor aslında. Bu işaretler, en sonda işe yarayacak.
 En sonda, bir dalganın daha sonraki dalgaları ileri doğru itmesi gibi; ilk sayıdan başlayarak son sayıya doğru bir dalga başlatıyor.
 
  İşte, bu dalga, önüne aldığı her sayının gücünü aslında bir sonrakilere de aktarıyor.
  Mesela, bir indexte "3" rakamına rastlamışsa, "3"ün gücünü ondan sonraki tüm rakamlara aktarmış oluyor.
  İşte, (endIndex +1) numaralı indexe, "value" değerinin negatif hâlini atma sebebi de bu. 
  Bu negatif değer de, dalga ile birlikte önündeki tüm indexlere gönderilecek.
  Böylece, startIndex'ten gelen rakamın gücü, endIndex'ten sonraki tüm rakamlar için sıfırlanmış, pasifleşmiş olacak. 
  Bu sayede sâdece startIndex ile endIndex arasına etki etmiş olacak.
  Zâten istediği de bu idi.


[1087. Brace Expansion](https://github.com/spiralgo/algorithms/issues/14)

Şuradaki çözüm uygun görünüyor:
https://leetcode.com/problems/brace-expansion/discuss/312361/Java-DFS

Bu çözüm vesilesi ile TreeSet veri yapısı öğrenilmeli.

[426. Convert Binary Search Tree to Sorted Doubly Linked List](https://github.com/spiralgo/algorithms/issues/15)

Bunu tam da düşündüğümüz gibi, Inorder rekürsif kullanarak çözmüş. Çünkü inorder zâten bir Binary Tree'ye, küçükten büyüğe sıralayarak veriyor.
Çözüm gayet akla yatkın.
Tanıma göre, eğer kökün sol alt ağacından sıralı bir linked list yaparsak, sonra sonuna kökü koyarsak, sonra ise sağ alt ağacından bunu oluşturursak elimizde bir tür LinkedList olmalı. Bu da özyineli algoritmayı verir. 

[1245. Tree Diameter](https://github.com/spiralgo/algorithms/issues/16)

Daha önce bunun altyapısı gibi düşünülebilecek, kısmen daha kolay bir soru olan "1522. Diameter of N-Ary Tree" çözmüştük.

Bu sorudaki püf nokta, en derinden yani yapraklardan başlayarak (depth-first) hesaplama yapmaktı.

Bir yaprağın uzunluğunu sıfır olarak kabul edip, bunun üzerinden üstteki node'ların uzunluğunu hesaplıyorduk.

Diameter, ya alt node'larda çıkabilirdi veyâhud daha üst node'lardan. Hangisi uzun ise (Math.max kullanarak) onu alıyorduk.

İşte bu çözümü aynı şekilde uyguladığı için aşina olduğumuz "Approach 3: DFS (Depth-First Search)" çözümü incelenmelidir.

[1538. Guess the Majority in a Hidden Array](https://github.com/spiralgo/algorithms/issues/17)

Burada en çok oy alan çözümün altında, "blackspinner" adlı kullanıcının gönderdiği gözden geçirilmiş çözümü submit ettim.
İnceledikçe, buradaki notu güncelleyeceğim.

[1136. Parallel Courses](https://github.com/spiralgo/algorithms/issues/18)

 Bu soruda Approach 1: Breadth-First Search (Kahn's Algorithm) çözümü gâyet uygun görünüyor.
 Bu vesîle ile Kahn algoritmasını da öğrenmiş olacağız.
 
 Türk çayı demlemek üzerinden Kahn's Algorithm'i anlattım.
Topolojik sıralama için gereken bu algoritmayı basit bir örnekle aklınızda tutmak istiyorsanız izlemenizi öneririm.
 Kamera sallanıyor ve dik tutmuşum, ama gene de çekim fenâ değil:
 https://youtu.be/99oTqO51Jh0
 
[510. Inorder Successor in BST II](https://github.com/spiralgo/algorithms/issues/19)

Bu soruda, "solution" kısmında verilen "Approach 1: Iteration" gayet anlaşılır görünüyor.

[635. Design Log Storage System](https://github.com/spiralgo/algorithms/issues/20)

Burada "Approach #2 Better Retrieval" performans bakımından daha iyi olduğundan ve TreeMap kullanımına dair yeni bir örnek olduğundan ötürü tercih edilmeli.

Burada convert methodu, tüm tarihleri saniye cinsine çevirmeye yarıyor.
Tarih aralığı en fazla 2000 olabileceği için, convert metodunda 1999L (long türünde 1999) çıkarılmış. 

Burada granularity metodunda yapılan şey, verilen "gra" değerinden sonraki tüm değerleri sıfırlamak. Çünkü onlar ciddiye alınmayacak.
Granularity metodundaki (boolean end) parametresi kontrol ediliyor çünkü eğer, bu gelen tarih; tarih aralığının bitişini gösteriyorsa; sıfırlama işleminden sonra "gra" ile belirtilen yerin "1" artırılması gerekiyor.

Çünkü, "put" ile girilen tarihleri TreeMap içerisine saniye cinsinden yazıyor. 
Tarih aralığına göre sorgulama yaparken TreeMap içerisindeki tailMap(start) netodunu kullanıyor. Bu method, parametre olarak gönderilen tarihe eşit veya ondan büyük olan tarihli listelerin id'lerini döndürür. (Log bilgisi ile gelen ID'yi key olarak kullanmıştık)


[531. Lonely Pixel I ](https://github.com/spiralgo/algorithms/issues/21)

Bu soruda en fazla puan alan çözüm gâyet anlaşılır görünüyor. 


[369. Plus One Linked List](https://github.com/spiralgo/algorithms/issues/22)

Bu soruda standart çözüm gayet uygun ve anlaşılır görünüyor:
Approach 1: Sentinel Head + Textbook Addition.

[281. Zigzag Iterator](https://github.com/spiralgo/algorithms/issues/23)

Burada kuyruk kullanılan Approach 2: Queue of Pointers, daha anlaşılır ve profesyonel görünüyor. 


[1135. Connecting Cities With Minimum Cost](https://github.com/spiralgo/algorithms/issues/24)

[Code](https://github.com/spiralgo/algorithms/blob/2f0b4d461c3e9a5afd2712b838aec56a7f7e4dab/src/main/java/algorithms/curated170/medium/ConnectingCitiesWithMinimumCost.java)

Bu gibi minimum-maksimum istenen sorularda genellik Greedy strateji uygulanır. Yani, neticenin gerçekten de maksimum-minimum olup olmadığına bakılmaksızın, yerel olarak
eldeki verilerden en uygun görünen ilkleri seçilerek işleme devam edilir.
 Böyle en düşük maliyetle şehir birleştirme sorularında standart olarak Kruskal algoritması kullanılır. Çünkü, Kruskal, bir graftaki minimum-spanning tree denilen, en az mâliyetli ağacı bukmak için kullanılan bir algoritmadır. (Prim's Algorithm gibi)
 Kruskal bize çok yabancı gelmeyecektir çünkü kendi içinde "arkadaş grubu" probleminden hatırladığımız 
 Union-Find veri yapısını kullanıyor.
 
 Dolayısı ile, her ne kadar çözüm uzun görünse de, aşağıdaki çözüm uygun:
 Approach 1: Minimum Spanning Tree (Using Kruskal's algorithm)

 [Minimum Swaps to Group All 1's Together](https://github.com/spiralgo/algorithms/issues/25)
 
 Bu soruda "Approach 1: Sliding Window with Two Pointers" çözümü gâyet uygun görünüyor. Önce pencere ile, en çok 1 içeren kısım bulunuyor. Bu, toplam 1 sayısından çıkarılıyor ve sonuç bulunuyor.
  
 [Design File System](https://github.com/spiralgo/algorithms/issues/26)
 
  Burada HashMap akla gelen ilk çözüm olduğu için, ilk çözüm önerisi olan "Approach 1: Dictionary for storing paths" gâyet makul görünüyor. 
  
 [Longest Repeating Substring](https://github.com/spiralgo/algorithms/issues/27)
 
 Burada "Approach 1: Binary Search + Hashset of Already Seen Strings" gayet anlaşılır görünüyor. Zâten ikinci çözümün de temeli bu. Üçüncüsü ise, şu ân için âcil olmayan bir formül öğretiyor. Buna vakit kaybetmek doğru görünmedi.
   		 
 [Group Shifted Strings](https://github.com/spiralgo/algorithms/issues/28)
 
 (Not: Bu sorunun çözüm mantığını daha iyi anlamak için başka bir soru olan "49. Group Anagrams" sorusunu incelemek faydalı olacaktır. Bu sorudaki temel çözüm mantığı, anagramları bir "anahtar" aracılığı ile gruplandırmaktı. Bu anahtar da, anagramın harflerinin küçükten büyüğe sıralanmış hâli olarak seçilmiş.)

 Bu soru için, en çok oy alan çözümün altındaki ilk yorumda verilen çözüm uygun görünüyor. Çünkü açıklamasını yapmış ve kod çok sâde görünüyor.
 Gene  "49. Group Anagrams" sorusunda olduğu gibi, kelîmeleri gruplandıracak bir anahtar aramış ve harflerin alfâbedeki sırasından yararlanarak bulmuş.
 
O çözüm şuradaki "diddit" adlı yazarın yorumundadır:
 https://leetcode.com/problems/group-shifted-strings/discuss/67442/My-Concise-JAVA-Solution
  		 
 [Remove Interval](https://github.com/spiralgo/algorithms/issues/29)
 
 Şuradaki çözüm, standart çözümden daha az ve öz görünüyor:
https://leetcode.com/problems/remove-interval/discuss/937333/Java-O(N)-check-left-and-right-boundary
   		 
 [Number of Distinct Islands](https://github.com/spiralgo/algorithms/issues/30)

  Çözümler arasında en akla yatkın olanı "Approach 3: Hash By Path Signature" olduğu için buna odaklanalım.

 [Number of Connected Components in an Undirected Graph](https://github.com/spiralgo/algorithms/issues/31)
  
  En çok puan almış olan şu çözüm gayet anlaşılır görünüyor:
  https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/77574/Easiest-2ms-Java-Solution

    		 
 [Campus Bikes](https://github.com/spiralgo/algorithms/issues/32)
 
  Şurada yeterince hızlı ve anlaşılır bir kod ve videolu anlatım var. İkinci video İngilizce.:
  Burada mantık Bucket Sort üzerine kurulmuş. Sonuçta uzaklık (distance) array'in uzunluğunun en fazla 2000 olabileceği bilindiğinden; bisiklet seçimleri en küçük index ile belirlendiğinden, bu soru aslında tam bir Bucket Sort sorusu haline geliyor.
https://leetcode.com/problems/campus-bikes/discuss/343953/Java-Solution-using-Bucket-Sort-with-Video-Explanation

 [Shortest Way to Form String](https://github.com/spiralgo/algorithms/issues/33)
  Buradaki ipucu şu: target'ın her bir harfi, source'un harflerini sırası ile gezerek oluşturulabiliyor mu? Bazen target'ın her bir harfi için source'u gezmeye baştan başlamak gerekir. İşte, kaç kere baştan başladığı soruluyor.
   Bunun için s(ource), t(arget), pt (target'ın o turdaki ilk konumu) şeklinde 3 pointer kullanıyor. Bunlardan s ve t hareket ediyor. Pointer s hareket edip, t hareketsiz kaldığında subsequence oluşturmak için gereken silme işlemini yapmış oluyor.

  Şuradaki çözüme odaklanalım:
https://leetcode.com/problems/shortest-way-to-form-string/discuss/304193/Java-Two-Pointers-Solution-With-Explanation		 

 [Ternary Expression Parser](https://github.com/spiralgo/algorithms/issues/34)
 
 Bu soru, kodlama editörlerinin nasıl çalıştığına dair fikir verecektir. Çünkü Ternary Expression zaten bizim de sürekli kullandığımız if-else kısaltmasıdır.
 Editörler işte bu şekilde parse ederek renklendiriyorlar. 
  
 Şu cevap Stack kullanılarak çözülmüş. Burada Deque, daha önce de bahsettiğim gibi hem Stack hem de Queue olarak kullanılabilen bir yapı.
 Gayet anlaşılır bir çözüm:
https://leetcode.com/problems/ternary-expression-parser/discuss/92166/Very-easy-1-pass-Stack-Solution-in-JAVA-(NO-STRING-CONCAT)

 Bu çözümde püf nokta, Ternary Expression'u  "?" ile karşılaşıncaya kadar tersten Stack'e yazmak.  "?" ile karşılaşmak, Stack'in tepesinde  "?" olması anlamındadır.
 Bu durumda, "?"'dan bir sonraki eleman 'T' veyâ 'F' olmalıdır. T ise ilkini, F ise ikincisini tekrârdan Stack'e atma sebebi, bu expression'un birden fazla ifâde içerme ihtimâlidir.
    	 
 [Walls and Gates](https://github.com/spiralgo/algorithms/issues/35)
 
 Buradaki kuyruk ile çözümü (Approach #2 (Breadth-first Search)) zâten en çok oy alan çözüm ile aynıdır.
 Dolayısı ile odaklanmamız gereken çözüm budur.
 
    	 
 [Shortest Word Distance III](https://github.com/spiralgo/algorithms/issues/36)
 
  Şuradaki çözüm başlığında, "Java fast" başlığı ile gösterilen ikinci çözüm bize uygun görünüyor:
https://leetcode.com/problems/shortest-word-distance-iii/discuss/67097/12-16-lines-Java-C%2B%2B

 [Design Tic-Tac-Toe](https://github.com/spiralgo/algorithms/issues/37)

 Başlıkta da belirtildiği gibi gâyet sâde ve anlaşılır bir çözüm:
https://leetcode.com/problems/design-tic-tac-toe/discuss/81898/Java-O(1)-solution-easy-to-understand

Burada püf nokta: diagonal (row == col olduğunda soldan sağa çapraz) ve antidiagonal (col == (cols.length - row - 1) olduğunda sağdan sola çapraz) kontrolleri yapmaktır.
Sağdan sola çapraz (antidiagonal) durumunda, row+col; satır (veyâ zaten eşit oldukları için sütun) sayısının 1 eksiğini verir. 
  
    		 
 [Missing Element in Sorted Array](https://github.com/spiralgo/algorithms/issues/38)
 
  Dizinin sıralı olması, bize Binary Search'ü hatırlatıyor. 
 Bu yüzden ikinci yaklaşım olan "Approach 2: Binary Search" çözümü iyidir.
     
 [Find the Index of the Large Integer](https://github.com/spiralgo/algorithms/issues/39)
 
   Gene Binary Search'ü hatırlatan bir soru. Şuradaki çözüm gayet uygundur:

   https://leetcode.com/problems/find-the-index-of-the-large-integer/discuss/763124/JavaC%2B%2BCPython-Binary-Search 		 
 
 [Meeting Scheduler](https://github.com/spiralgo/algorithms/issues/40)
 
  İki pointer kullanılan "Approach 1: Two pointers" çözümünün anlaşılması daha kolaydır. Özetle, bu iki kişinin o ânki slotları arasındaki kesişen zamânı buluyor.
  Bu kesişen zamân eğer "duration"u tatmin ediyorsa, bunu döndürüyor. Yok eğer yetmiyorsa, pointerlardan birini hareket ettiriyor. Hangi slot erken bitiyorsa, o slotun pointerını hareket ettiriyor.

  Bu soruyu, PriorityQueue veri yapısına dair tecrübemizi genişletmek adına bir fırsat olarak görmek istersek "Approach 2: Heap" çözümü gâyet yerindedir.

 [Shortest Word Distance II](https://github.com/spiralgo/algorithms/issues/42)
 
 
   Çözüm kısmında, HashMap kullanılarak yapılan "Approach 1: Using Preprocessed Sorted Indices" bu bakış açısı güzel.
     Özetle yaptığı; Bir HashMap'te her bir kelîmeyi "key" olarak kullanıyor ve onunla karşılaştığı indexlerin Listesini de "value" olarak kullanıyor.
     "Preprocessed Sorted Indices" demesinin sebebi, "value"deki listenin sıralı olmasıdır.
     Daha sonra bu o ân "en kısa uzaklık" hesaplanması istenen kelîmelerin index listelerini alıyor. Liste elemanlarını tek tek karşılaştırıyor. 

      
 [Campus Bikes II](https://github.com/spiralgo/algorithms/issues/41)
 
   Şu çözümdeki, ikinci bakış açısı bize uygun görünüyor:
https://leetcode.com/problems/campus-bikes-ii/discuss/412367/Java-DFS-And-DP-Solution-with-Video-Explanation-(Chinese-and-English)

[Generalized Abbreviation](https://github.com/spiralgo/algorithms/issues/43)


   Bu bahâne ile Backtracking meselesini araştırmamız iyi olacaktır. Backtracking, bir satranç oyununda, bir sonraki hamleleri kafada hesaplayıp uygun olmayan hamleleri elemeye benzetilebilir. Kafada satranç tahtalarını ilerletip, olmayınca adımları geri sarmak gibi.
        Bu yüzden şu çözüm iyidir: "Approach #1 (Backtracking)"
	
   Detaylı not:	
   1-
   Şu videoda Backtrackingi anlattım:
   Umarım bir faydası olur.
   Neden algoritma çalışmamız gerektiği gibi daha derin meselelerden de az da olsa bahsettim.
   https://youtu.be/uYrWVTPGUaw
   2-
   Şurada Abdul Bari, Backtracingi basit bir örnekle anlatmış:
    https://www.youtube.com/watch?v=DKCbsiDBN6c
   "İki erkek ve bir kız, 3 sandalyeye kaç farklı şekilde oturabilir?"
   Bu gene YKS ile ilgili bir permutasyon sorusu.
   Ama bunu Backtracking ile çözmeye kalkınca ortaya bir ağaç çıkıyor.
   Backtracking'de "geri çekilme" diye bir mesele var. Yani, eğer hamle işe yaramıyorsa, o hamleyi geri çekmek.
   Bu soruda, ilk başta bunu gerektiren bir kısıtlama (constraint) yok.
   Ama 4 dakikada bir kısıtlma belirliyor.
   Kısıtlamayı şöyle koyuyor? :
  "Girl should not sit in middle" (kız oraya oturamaz)
  Bu kısıtlamayı koyunca, artık ağaçtaki her bir dal çözüm olamıyor. Bu kısıtlılıktan ötürü, önce ağacın dalını gezip, buna uymayanları elemen gerekiyor.
  Ağacın dalının bir düğümünde, bu kısıtlılığa uymayan bir yerle karşılaştı isen, hemen geri bir önceki düğüme geri çekiliyorsun.


 [Paint House](https://github.com/spiralgo/algorithms/issues/44)
 
 Bu bir "Dynamic Programming" sorusudur.  "Dynamic Programming", bir problemin daha küçük parçaları için yapılan çözümleri hafızaya depolayıp, onu problemin diğer parçaları için de kullanmak olarak tanımlanabilir. Bunu anlamak için öncelikle  "Dynamic Programming" kullanılarak yapılan "faktöriyel" programı yazılabilir.
        Bu bir  "Dynamic Programming" sorusu olduğundan bunun açıklamasını, "Solution" kısmında en altta yapmışlar. En alttaki çözüm bizim için de uygundur.
 
 [Count Univalue Subtrees](https://github.com/spiralgo/algorithms/issues/45)
 
   Approach 1: Depth First Search, bizim bakış açımıza gayet uygundur.

 [Shortest Distance to Target Color](https://github.com/spiralgo/algorithms/issues/46)
 
  "Approach 1: Binary Search" bizim için tanıdık bir konu olduğundan, bu çözüm iyidir.
       
 [4 Keys Keyboard](https://github.com/spiralgo/algorithms/issues/47)
 Şurada dinamik programlama kullanılarak yapılan ikinci çözüm uygundur. Güzel bir şekilde açıklamış:
"Approach #1: Dynamic Programming [Accepted]"


 [The Maze](https://github.com/spiralgo/algorithms/issues/48)
 
  Standart çözümde verilen "Approach 1: Depth First Search" bize uygun görünüyor.

 [Construct Binary Tree from String](https://github.com/spiralgo/algorithms/issues/49)
  
  Standart çözümde verilen "Approach 2: Stack" yöntemi, bu sorudaki "açık-kapalı" parantez mantığına uygun olduğu için buna odaklanalım.

 [Path With Maximum Minimum Value](https://github.com/spiralgo/algorithms/issues/50)
   
  
(Mümkün yollardaki minimum değerlerden, maksimum olanını sorduğu için soru biraz kafa karıştırıcı olabilir. )

Bu soru PriorityQueue, Union Find, Binary Search kullanılarak çözülebiliyor.

 Binary Search kullanılan yöntem en hızlısı olsa gerekir. 
 Binary search, aranan değerin 0 ile  (high = Math.min(A[0][0], A[row-1][col-1])) değeri arasında olması gerektiği gerçeğine dayanır.
 Çünkü bu iki node'un (yani A[0][0] ve A[row-1][col-1]) "mümkün yollar" üzerinde olması gerektiği kesindir. 
 High değeri, mümkün olan yollar içerisinde eğer minimumsa, skor zâten odur.
 Eğer maksimumsa, aranan değerin 1 ile high arasında olacağı gerçeği değişmez. Bu yüzden low = 1 ile High+1 arasında Binary Search yaparak "low" değişkeninin alabileceği maksimum değeri ararız.

 [Longest Substring with At Most Two Distinct Characters](https://github.com/spiralgo/algorithms/issues/51)
  
 Bu tür sorular genelde pencere yöntemi ile çözülür. Dolayısı ile "Approach 1: Sliding Window" uygundur.

 [Sort Transformed Array](https://github.com/spiralgo/algorithms/issues/51)

 Şuradaki çözüm gayet yalın görünüyor:
   https://leetcode.com/problems/sort-transformed-array/discuss/83322/Java-O(n)-incredibly-short-yet-easy-to-understand-AC-solution
   
 [First Unique Number](https://github.com/spiralgo/algorithms/issues/53)
 
Standart çözümdeki  "Approach 2: Queue and HashMap of Unique-Status" bu soruya uygun görünüyor.

 [Leftmost Column with at Least a One](https://github.com/spiralgo/algorithms/issues/54)
  
  Binary search bizim için tanıdık bir yöntem olduğundan	 "Approach 2: Binary Search Each Row" çözümü uygundur.
 
 [3Sum Smaller](https://github.com/spiralgo/algorithms/issues/55)
  
Standart çözümdeki  "Approach #3 (Two Pointers)" bu soru için uygun görünüyor.

 [Strobogrammatic Number II](https://github.com/spiralgo/algorithms/issues/57)
  
  Şu başlıktaki çözüm gâyet yalın görünüyor:
https://leetcode.com/problems/strobogrammatic-number-ii/discuss/67280/AC-clean-Java-solution
  
 [The Maze II](https://github.com/spiralgo/algorithms/issues/56)	
   
 Bunda da aynı şekilde ilk Maze (labirent) sorusunda yaptığımız gibi standart çözümdeki "Approach #1 Depth First Search" yöntemini seçelim.

 [Binary Tree Longest Consecutive Sequence](https://github.com/spiralgo/algorithms/issues/58)
   	
 "Approach #2 (Bottom Up Depth-first Search)"dakine benzer bir çözümü "Tree Diameter" sorusunda kullandığımız için bu çözüm
    
 [Max Consecutive Ones II](https://github.com/spiralgo/algorithms/issues/59)
   
Bununla bağlantılı olan 1151. "Minimum Swaps to Group All 1's Together" sorusunda yaptığımız gibi, bunda da pencere yöntemini (Approach 2: Sliding Window) seçelim.

 [Factor Combinations](https://github.com/spiralgo/algorithms/issues/60)	
    		
İkinci en yüksek puanı almış olan çözüm, ilkinden çok daha hızlı:
https://leetcode.com/problems/factor-combinations/discuss/68039/A-simple-java-solution

 [Maximum Size Subarray Sum Equals k](https://github.com/spiralgo/algorithms/issues/61)
  
  Şuradaki HashMap içeren çözüm gayet yalın ve anlaşılır:
https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/77784/O(n)-super-clean-9-line-Java-solution-with-HashMap
 [Binary Tree Longest Consecutive Sequence II](https://github.com/spiralgo/algorithms/issues/62)
    "Approach #2 Single traversal" çözümü gayet anlaşılır ve hızlı.

 [Binary Tree Vertical Order Traversal](https://github.com/spiralgo/algorithms/issues/63)
    	
 Diğer birçok Tree sorusunda olduğu gibi, burada da derinlik öncelikli arama "Approach 3: Depth-First Search (DFS)" daha uygun görünüyor.

 [Meeting Rooms II](https://github.com/spiralgo/algorithms/issues/64)
  
 Standart çözümdeki "Approach 2: Chronological Ordering" yaklaşımı, zannedersem aynı zamanda en çok puanı almış olan çözüm ile aynı mantığı izliyor.

 [Bomb Enemy](https://github.com/spiralgo/algorithms/issues/65)

 Burada "Approach 2: Dynamic Programming" yaklaşımı uygundur.

 [Sentence Similarity II](https://github.com/spiralgo/algorithms/issues/66)

  Burada bize union-find kullanımını hatırlatması açısından "Approach #2: Union-Find" yaklaşımı iyidir. Standart çözümde birkaç değişiklik gerekiyordu. Liste yerine array kullanılmıştı, onu düzelttik.

 [Flatten 2D Vector](https://github.com/spiralgo/algorithms/issues/67)	
    	
  Approach 2: Two Pointers, yaklaşımı gayet kolay. Çözüm kısmında lâfı fazla uzatmışlar ama göründüğü kadar zor değil.

 [Verify Preorder Sequence in Binary Search Tree](https://github.com/spiralgo/algorithms/issues/69)
 
  Şuradaki en fazla puan alan çözüm uygundur:
 
  https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/discuss/68142/Java-O(n)-and-O(1)-extra-space

 [Longest Line of Consecutive One in Matrix](https://github.com/spiralgo/algorithms/issues/68)

   Standart çözümler pek beğenilmemiş. Şurada en iyi puanı alan Java kodu uygun görünüyor:
https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/discuss/102266/Java-O(nm)-Time-DP-Solution

 [Reverse Words in a String II](https://github.com/spiralgo/algorithms/issues/70)
  
 Standart çözüm uygun görünüyor:
"Approach 1: Reverse the Whole String and Then Reverse Each Word"
 	
 [Longest Substring with At Most K Distinct Characters](https://github.com/spiralgo/algorithms/issues/71)	
  
 Daha önce çözdüğümüz "159. Longest Substring with At Most Two Distinct Characters" sorusu ile neredeyse aynıdır. Çözüm de aynı şekilde pencere ve HashMap ile yapılacaktır.
   Bu yüzden "Approach 1: Sliding Window + Hashmap." uygundur.

 [Add Bold Tag in String](https://github.com/spiralgo/algorithms/issues/72)	
 
 Şuradaki çözüm zekice görünüyor:
https://leetcode.com/problems/add-bold-tag-in-string/discuss/104248/Java-Solution-boolean-array

 [Closest Leaf in a Binary Tree](https://github.com/spiralgo/algorithms/issues/73)	
 
   Binary Tree'yi önce bir Graf'a çevirmeyi öğrettiği için şu çözüm uygun görünüyor: Approach #1: Convert to Graph [Accepted]

 [Word Pattern II](https://github.com/spiralgo/algorithms/issues/74)	
 
   Daha önce öğrendiğimiz	"Backtracking" metodu kullandığı için, buradaki çözüm uygun görünüyor.
https://leetcode.com/problems/word-pattern-ii/discuss/73664/Share-my-Java-backtracking-solution

 [Find the Celebrity](https://github.com/spiralgo/algorithms/issues/75)	
 
   Standart çözümdeki "mantıksal çıkarım" yani "Approach 2: Logical Deduction" yöntemi uygun görünüyor.
	
 [Graph Valid Tree](https://github.com/spiralgo/algorithms/issues/76)
 
   Daha önceden bildiğimiz Union-find kullandığı için "Approach 3: Advanced Graph Theory + Union Find" çözümü uygundur.

 [Inorder Successor in BST](https://github.com/spiralgo/algorithms/issues/77)
 
   Bu bir binary search tree olduğu için, doğal olarak "Approach 2: Using BST properties" uygun çözümdür.

 [All Paths from Source Lead to Destination](https://github.com/spiralgo/algorithms/issues/78)	
 
 Standart çözüm: "Approach: Depth First Search" bize uygun görünüyor.
    	
 [Boundary of Binary Tree](https://github.com/spiralgo/algorithms/issues/79)
    
   Preorder sıralama, az çok burada istediği gibi, bir ağacı sarmalayarak ilerlediği için, en uygun çözüm doğal olarak: 
    Approach #2 Using PreOrder Traversal 

 [Maximum Distance in Arrays](https://github.com/spiralgo/algorithms/issues/80)
    
   Şuradaki çözüm, muhtemelen standart çözümde de kullanılmış:
https://leetcode.com/problems/maximum-distance-in-arrays/discuss/104613/Java-Solution-Min-and-Max

 [Paint Fence](https://github.com/spiralgo/algorithms/issues/81)

  Standart çözümdeki "Approach 2: Dynamic Programming 1D - Bottom Up" bize uygun görünüyor.

 [Largest BST Subtree](https://github.com/spiralgo/algorithms/issues/82)
    	
   Şuradaki çözüm uygun görünüyor:
     https://leetcode.com/problems/largest-bst-subtree/discuss/78899/Very-Short-Simple-Java-O(N)-Solution

 [Palindrome Permutation II](https://github.com/spiralgo/algorithms/issues/83)	
    		Backtracking kullanılan şu yöntem uygun görünüyor: "Approach #2 Backtracking"  

 [Minimum Knight Moves](https://github.com/spiralgo/algorithms/issues/84)
 
   Şuradaki çözümde her şey adım adım açıklanmış:
    https://leetcode.com/problems/minimum-knight-moves/discuss/392053/Here-is-how-I-get-the-formula-(with-graphs)
 
 [Design Snake Game](https://github.com/spiralgo/algorithms/issues/85)

   Standart çözüm gâyet uygun görünüyor.

 [One Edit Distance](https://github.com/spiralgo/algorithms/issues/86)

  Standart çözüm (Approach 1: One pass algorithm) gayet uygun görünüyor.

 [Encode and Decode Strings](https://github.com/spiralgo/algorithms/issues/87)
 
   Şuradaki çözüm en çok oy alanlar arasında ve gâyet anlaşılır görünüyor:
  https://leetcode.com/problems/encode-and-decode-strings/discuss/70412/AC-Java-Solution
 
 [Insert into a Sorted Circular Linked List](https://github.com/spiralgo/algorithms/issues/88)
   	Böyle Linked List sorularında, iki pointer kullanmak akla yatkın görünüyor:
   "Approach 1: Two-Pointers Iteration"

**HARD:**

 [431. Encode N-ary Tree to Binary Tree:](https://github.com/spiralgo/algorithms/issues/89)

 [489. Robot Room Cleaner:](https://github.com/spiralgo/algorithms/issues/90)

 [759. Employee Free Time:](https://github.com/spiralgo/algorithms/issues/91)

 [1274. Number of Ships in a Rectangle:](https://github.com/spiralgo/algorithms/issues/92)
 
 [428. Serialize and Deserialize N-ary Tree:](https://github.com/spiralgo/algorithms/issues/210)

[1168. Optimize Water Distribution in a Village:](https://github.com/spiralgo/algorithms/issues/211)

[296. Best Meeting Point:](https://github.com/spiralgo/algorithms/issues/212)

[1183. Maximum Number of Ones:](https://github.com/spiralgo/algorithms/issues/213)

[527. Word Abbreviation:](https://github.com/spiralgo/algorithms/issues/214)

[1548. The Most Similar Path in a Graph:](https://github.com/spiralgo/algorithms/issues/215)

[1259. Handshakes That Don't Cross:](https://github.com/spiralgo/algorithms/issues/216)

[1231. Divide Chocolate:](https://github.com/spiralgo/algorithms/issues/217)

[272. Closest Binary Search Tree Value II:](https://github.com/spiralgo/algorithms/issues/218)

[302. Smallest Rectangle Enclosing Black Pixels:](https://github.com/spiralgo/algorithms/issues/219)

[425. Word Squares:](https://github.com/spiralgo/algorithms/issues/220)

[1216. Valid Palindrome III:](https://github.com/spiralgo/algorithms/issues/221)

[471. Encode String with Shortest Length:](https://github.com/spiralgo/algorithms/issues/222)
 
[774. Minimize Max Distance to Gas Station:](https://github.com/spiralgo/algorithms/issues/223)

[465. Optimal Account Balancing:](https://github.com/spiralgo/algorithms/issues/224)

[642. Design Search Autocomplete System:](https://github.com/spiralgo/algorithms/issues/225)

[588. Design In-Memory File System:](https://github.com/spiralgo/algorithms/issues/226) 

[265. Paint House II:](https://github.com/spiralgo/algorithms/issues/227) 

[1088. Confusing Number II:](https://github.com/spiralgo/algorithms/issues/228) 

[772. Basic Calculator III:](https://github.com/spiralgo/algorithms/issues/229) 

[317. Shortest Distance from All Buildings:](https://github.com/spiralgo/algorithms/issues/230) 
  		 		
[499. The Maze III:](https://github.com/spiralgo/algorithms/issues/231) 

[727. Minimum Window Subsequence:](https://github.com/spiralgo/algorithms/issues/232) 

[568. Maximum Vacation Days:](https://github.com/spiralgo/algorithms/issues/233) 

[305. Number of Islands II:](https://github.com/spiralgo/algorithms/issues/234) 

[1199. Minimum Time to Build Blocks:](https://github.com/spiralgo/algorithms/issues/235) 

[308. Range Sum Query 2D - Mutable:](https://github.com/spiralgo/algorithms/issues/236) 

[158. Read N Characters Given Read4 II - Call multiple times:](https://github.com/spiralgo/algorithms/issues/237) 

[358. Rearrange String k Distance Apart:](https://github.com/spiralgo/algorithms/issues/238) 

[1153. String Transforms Into Another String:](https://github.com/spiralgo/algorithms/issues/239) 

[644. Maximum Average Subarray II:](https://github.com/spiralgo/algorithms/issues/240) 

[269. Alien Dictionary:](https://github.com/spiralgo/algorithms/issues/241) 

[631. Design Excel Sum Formula:](https://github.com/spiralgo/algorithms/issues/242) 

[656. Coin Path:](https://github.com/spiralgo/algorithms/issues/243) 
 
