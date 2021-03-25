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

Burada en çok oy alan çözümün altında, "blackspinner" adlı kullanıcının gönderdiği gözden geçirilmiş çözümü submit ettim.
İnceledikçe, buradaki notu güncelleyeceğim.

[1136. Parallel Courses](https://github.com/altayhunoglu/algorithms/issues/18)

 Bu soruda Approach 1: Breadth-First Search (Kahn's Algorithm) çözümü gâyet uygun görünüyor.
 Bu vesîle ile Kahn algoritmasını da öğrenmiş olacağız.
 
 Türk çayı demlemek üzerinden Kahn's Algorithm'i anlattım.
Topolojik sıralama için gereken bu algoritmayı basit bir örnekle aklınızda tutmak istiyorsanız izlemenizi öneririm.
 Kamera sallanıyor ve dik tutmuşum, ama gene de çekim fenâ değil:
 https://youtu.be/99oTqO51Jh0
 
[510. Inorder Successor in BST II](https://github.com/altayhunoglu/algorithms/issues/19)

Bu soruda, "solution" kısmında verilen "Approach 1: Iteration" gayet anlaşılır görünüyor.

[635. Design Log Storage System](https://github.com/altayhunoglu/algorithms/issues/20)

Burada "Approach #2 Better Retrieval" performans bakımından daha iyi olduğundan ve TreeMap kullanımına dair yeni bir örnek olduğundan ötürü tercih edilmeli.

Burada convert methodu, tüm tarihleri saniye cinsine çevirmeye yarıyor.
Tarih aralığı en fazla 2000 olabileceği için, convert metodunda 1999L (long türünde 1999) çıkarılmış. 

Burada granularity metodunda yapılan şey, verilen "gra" değerinden sonraki tüm değerleri sıfırlamak. Çünkü onlar ciddiye alınmayacak.
Granularity metodundaki (boolean end) parametresi kontrol ediliyor çünkü eğer, bu gelen tarih; tarih aralığının bitişini gösteriyorsa; sıfırlama işleminden sonra "gra" ile belirtilen yerin "1" artırılması gerekiyor.

Çünkü, "put" ile girilen tarihleri TreeMap içerisine saniye cinsinden yazıyor. 
Tarih aralığına göre sorgulama yaparken TreeMap içerisindeki tailMap(start) netodunu kullanıyor. Bu method, parametre olarak gönderilen tarihe eşit veya ondan büyük olan tarihli listelerin id'lerini döndürür. (Log bilgisi ile gelen ID'yi key olarak kullanmıştık)


[531. Lonely Pixel I ](https://github.com/altayhunoglu/algorithms/issues/21)

Bu soruda en fazla puan alan çözüm gâyet anlaşılır görünüyor. 


[369. Plus One Linked List](https://github.com/altayhunoglu/algorithms/issues/22)

Bu soruda standart çözüm gayet uygun ve anlaşılır görünüyor:
Approach 1: Sentinel Head + Textbook Addition.

[281. Zigzag Iterator](https://github.com/altayhunoglu/algorithms/issues/23)

Burada kuyruk kullanılan Approach 2: Queue of Pointers, daha anlaşılır ve profesyonel görünüyor. 


[1135. Connecting Cities With Minimum Cost](https://github.com/altayhunoglu/algorithms/issues/24)

[Code](https://github.com/altayhunoglu/algorithms/blob/2f0b4d461c3e9a5afd2712b838aec56a7f7e4dab/src/main/java/algorithms/curated170/medium/ConnectingCitiesWithMinimumCost.java)

Bu gibi minimum-maksimum istenen sorularda genellik Greedy strateji uygulanır. Yani, neticenin gerçekten de maksimum-minimum olup olmadığına bakılmaksızın, yerel olarak
eldeki verilerden en uygun görünen ilkleri seçilerek işleme devam edilir.
 Böyle en düşük maliyetle şehir birleştirme sorularında standart olarak Kruskal algoritması kullanılır. Çünkü, Kruskal, bir graftaki minimum-spanning tree denilen, en az mâliyetli ağacı bukmak için kullanılan bir algoritmadır. (Prim's Algorithm gibi)
 Kruskal bize çok yabancı gelmeyecektir çünkü kendi içinde "arkadaş grubu" probleminden hatırladığımız 
 Union-Find veri yapısını kullanıyor.
 
 Dolayısı ile, her ne kadar çözüm uzun görünse de, aşağıdaki çözüm uygun:
 Approach 1: Minimum Spanning Tree (Using Kruskal's algorithm)

 [Minimum Swaps to Group All 1's Together](https://github.com/altayhunoglu/algorithms/issues/25)
 
 Bu soruda "Approach 1: Sliding Window with Two Pointers" çözümü gâyet uygun görünüyor. Önce pencere ile, en çok 1 içeren kısım bulunuyor. Bu, toplam 1 sayısından çıkarılıyor ve sonuç bulunuyor.
  
 [Design File System](https://github.com/altayhunoglu/algorithms/issues/26)
 
  Burada HashMap akla gelen ilk çözüm olduğu için, ilk çözüm önerisi olan "Approach 1: Dictionary for storing paths" gâyet makul görünüyor. 
  
 [Longest Repeating Substring](https://github.com/altayhunoglu/algorithms/issues/27)
 
 Burada "Approach 1: Binary Search + Hashset of Already Seen Strings" gayet anlaşılır görünüyor. Zâten ikinci çözümün de temeli bu. Üçüncüsü ise, şu ân için âcil olmayan bir formül öğretiyor. Buna vakit kaybetmek doğru görünmedi.
   		 
 [Group Shifted Strings](https://github.com/altayhunoglu/algorithms/issues/28)
 
 (Not: Bu sorunun çözüm mantığını daha iyi anlamak için başka bir soru olan "49. Group Anagrams" sorusunu incelemek faydalı olacaktır. Bu sorudaki temel çözüm mantığı, anagramları bir "anahtar" aracılığı ile gruplandırmaktı. Bu anahtar da, anagramın harflerinin küçükten büyüğe sıralanmış hâli olarak seçilmiş.)

 Bu soru için, en çok oy alan çözümün altındaki ilk yorumda verilen çözüm uygun görünüyor. Çünkü açıklamasını yapmış ve kod çok sâde görünüyor.
 Gene  "49. Group Anagrams" sorusunda olduğu gibi, kelîmeleri gruplandıracak bir anahtar aramış ve harflerin alfâbedeki sırasından yararlanarak bulmuş.
 
O çözüm şuradaki "diddit" adlı yazarın yorumundadır:
 https://leetcode.com/problems/group-shifted-strings/discuss/67442/My-Concise-JAVA-Solution
  		 
 [Remove Interval](https://github.com/altayhunoglu/algorithms/issues/29)
 
 Şuradaki çözüm, standart çözümden daha az ve öz görünüyor:
https://leetcode.com/problems/remove-interval/discuss/937333/Java-O(N)-check-left-and-right-boundary
   		 
 [Number of Distinct Islands](https://github.com/altayhunoglu/algorithms/issues/30)

  Çözümler arasında en akla yatkın olanı "Approach 3: Hash By Path Signature" olduğu için buna odaklanalım.

 [Number of Connected Components in an Undirected Graph](https://github.com/altayhunoglu/algorithms/issues/31)
  
  En çok puan almış olan şu çözüm gayet anlaşılır görünüyor:
  https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/77574/Easiest-2ms-Java-Solution

    		 
 [Campus Bikes](https://github.com/altayhunoglu/algorithms/issues/32)
 
    	 Şurada yeterince hızlı ve anlaşılır bir kod var:

https://leetcode.com/problems/campus-bikes/discuss/309284/Java-counting-sort-solution-47ms-(100)

 [Shortest Way to Form String](https://github.com/altayhunoglu/algorithms/issues/33)
 
     Şuradaki çözüme odaklanalım:
https://leetcode.com/problems/shortest-way-to-form-string/discuss/304193/Java-Two-Pointers-Solution-With-Explanation		 

 [Ternary Expression Parser](https://github.com/altayhunoglu/algorithms/issues/34)
 
 Bu soru, kodlama editörlerinin nasıl çalıştığına dair fikir verecektir. Çünkü Ternary Expression zaten bizim de sürekli kullandığımız if-else kısaltmasıdır.
 Editörler işte bu şekilde parse ederek renklendiriyorlar. 
 Şu cevap Stack kullanılarak çözülmüş. Burada Deque, daha önce de bahsettiğim gibi hem Stack hem de Queue olarak kullanılabilen bir yapı.
 Gayet anlaşılır bir çözüm:
https://leetcode.com/problems/ternary-expression-parser/discuss/92166/Very-easy-1-pass-Stack-Solution-in-JAVA-(NO-STRING-CONCAT)
    	 
 [Walls and Gates](https://github.com/altayhunoglu/algorithms/issues/35)
 
 Buradaki kuyruk ile çözümü (Approach #2 (Breadth-first Search)) zâten en çok oy alan çözüm ile aynıdır.
 Dolayısı ile odaklanmamız gereken çözüm budur.
 
    	 
 [Shortest Word Distance III](https://github.com/altayhunoglu/algorithms/issues/36)
 
  Şuradaki çözüm başlığında, "Java fast" başlığı ile gösterilen ikinci çözüm bize uygun görünüyor:
https://leetcode.com/problems/shortest-word-distance-iii/discuss/67097/12-16-lines-Java-C%2B%2B

 [Design Tic-Tac-Toe](https://github.com/altayhunoglu/algorithms/issues/37)

 Başlıkta da belirtildiği gibi gâyet sâde ve anlaşılır bir çözüm:
https://leetcode.com/problems/design-tic-tac-toe/discuss/81898/Java-O(1)-solution-easy-to-understand
    		 
 [Missing Element in Sorted Array](https://github.com/altayhunoglu/algorithms/issues/38)
 
  Dizinin sıralı olması, bize Binary Search'ü hatırlatıyor. 
 Bu yüzden ikinci yaklaşım olan "Approach 2: Binary Search" çözümü iyidir.
     
 [Find the Index of the Large Integer](https://github.com/altayhunoglu/algorithms/issues/39)
 
   Gene Binary Search'ü hatırlatan bir soru. Şuradaki çözüm gayet uygundur:

   https://leetcode.com/problems/find-the-index-of-the-large-integer/discuss/763124/JavaC%2B%2BCPython-Binary-Search 		 
 
 [Meeting Scheduler](https://github.com/altayhunoglu/algorithms/issues/40)
 
  Bu soruyu, PriorityQueue veri yapısına dair tecrübemizi genişletmek adına bir fırsat olarak görelim. Bu yüzden
      "Approach 2: Heap" çözümü gâyet yerindedir.

 [Shortest Word Distance II](https://github.com/altayhunoglu/algorithms/issues/41)
 
   Çözüm kısmında, HashMap kullanılarak yapılan "Approach 1: Using Preprocessed Sorted Indices" bu bakış açısı güzel.
      
 [Campus Bikes II](https://github.com/altayhunoglu/algorithms/issues/42)
 
   Şu çözümdeki, ikinci bakış açısı bize uygun görünüyor:
      https://leetcode.com/problems/campus-bikes-ii/discuss/360037/Step-by-Step-solution-from-400ms-to-1ms-(beating-100)
 [Generalized Abbreviation](https://github.com/altayhunoglu/algorithms/issues/43)
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


 [Paint House](https://github.com/altayhunoglu/algorithms/issues/44)
 
 Bu bir "Dynamic Programming" sorusudur.  "Dynamic Programming", bir problemin daha küçük parçaları için yapılan çözümleri hafızaya depolayıp, onu problemin diğer parçaları için de kullanmak olarak tanımlanabilir. Bunu anlamak için öncelikle  "Dynamic Programming" kullanılarak yapılan "faktöriyel" programı yazılabilir.
        Bu bir  "Dynamic Programming" sorusu olduğundan bunun açıklamasını, "Solution" kısmında en altta yapmışlar. En alttaki çözüm bizim için de uygundur.
 
 [Count Univalue Subtrees](https://github.com/altayhunoglu/algorithms/issues/45)
 
   Approach 1: Depth First Search, bizim bakış açımıza gayet uygundur.

 [Shortest Distance to Target Color](https://github.com/altayhunoglu/algorithms/issues/46)
 
  "Approach 1: Binary Search" bizim için tanıdık bir konu olduğundan, bu çözüm iyidir.
       
 [4 Keys Keyboard](https://github.com/altayhunoglu/algorithms/issues/47)
    		 	Şurada dinamik programlama kullanılarak yapılan ikinci çözüm uygundur. Güzel bir şekilde açıklamış:
https://leetcode.com/problems/4-keys-keyboard/discuss/105980/Java-4-lines-recursion-with-step-by-step-explanation-to-derive-DP

 [The Maze](https://github.com/altayhunoglu/algorithms/issues/48)
 
  Standart çözümde verilen "Approach 1: Depth First Search" bize uygun görünüyor.

 [Construct Binary Tree from String](https://github.com/altayhunoglu/algorithms/issues/49)
  
  Standart çözümde verilen "Approach 2: Stack" yöntemi, bu sorudaki "açık-kapalı" parantez mantığına uygun olduğu için buna odaklanalım.

 [Path With Maximum Minimum Value](https://github.com/altayhunoglu/algorithms/issues/50)
   
   Bu çözüm, minimum-maksimum yol problemlerinin gözde algoritması olan Dijkstra'yı çalışmak için iyi bir bahâne olduğundan, şu çözümü seçiyoruz:
https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/324923/Clear-Code-Dijkstra-Algorithm-(C%2B%2BJavaPythonGoPHP)

 [Longest Substring with At Most Two Distinct Characters](https://github.com/altayhunoglu/algorithms/issues/51)
  
 Bu tür sorular genelde pencere yöntemi ile çözülür. Dolayısı ile "Approach 1: Sliding Window" uygundur.

 [Sort Transformed Array](https://github.com/altayhunoglu/algorithms/issues/51)

 Şuradaki çözüm gayet yalın görünüyor:
   https://leetcode.com/problems/sort-transformed-array/discuss/83322/Java-O(n)-incredibly-short-yet-easy-to-understand-AC-solution
 [First Unique Number](https://github.com/altayhunoglu/algorithms/issues/53)
 
Standart çözümdeki  "Approach 2: Queue and HashMap of Unique-Status" bu soruya uygun görünüyor.

 [Leftmost Column with at Least a One](https://github.com/altayhunoglu/algorithms/issues/54)
  
  Binary search bizim için tanıdık bir yöntem olduğundan	 "Approach 2: Binary Search Each Row" çözümü uygundur.
 
 [3Sum Smaller](https://github.com/altayhunoglu/algorithms/issues/55)
  
Standart çözümdeki  "Approach #3 (Two Pointers)" bu soru için uygun görünüyor.

 [Strobogrammatic Number II](https://github.com/altayhunoglu/algorithms/issues/57)
  
  Şu başlıktaki çözüm gâyet yalın görünüyor:
https://leetcode.com/problems/strobogrammatic-number-ii/discuss/67280/AC-clean-Java-solution
  
 [The Maze II](https://github.com/altayhunoglu/algorithms/issues/56)	
   
 Bunda da aynı şekilde ilk Maze (labirent) sorusunda yaptığımız gibi standart çözümdeki "Approach #1 Depth First Search" yöntemini seçelim.

 [Binary Tree Longest Consecutive Sequence](https://github.com/altayhunoglu/algorithms/issues/58)
   	
 "Approach #2 (Bottom Up Depth-first Search)"dakine benzer bir çözümü "Tree Diameter" sorusunda kullandığımız için bu çözüm
    
 [Max Consecutive Ones II](https://github.com/altayhunoglu/algorithms/issues/59)
   
Bununla bağlantılı olan 1151. "Minimum Swaps to Group All 1's Together" sorusunda yaptığımız gibi, bunda da pencere yöntemini (Approach 2: Sliding Window) seçelim.

 [Factor Combinations](https://github.com/altayhunoglu/algorithms/issues/60)	
    		
İkinci en yüksek puanı almış olan çözüm, ilkinden çok daha hızlı:
https://leetcode.com/problems/factor-combinations/discuss/68039/A-simple-java-solution

 [Maximum Size Subarray Sum Equals k](https://github.com/altayhunoglu/algorithms/issues/61)
  
  Şuradaki HashMap içeren çözüm gayet yalın ve anlaşılır:
https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/77784/O(n)-super-clean-9-line-Java-solution-with-HashMap
 [Binary Tree Longest Consecutive Sequence II](https://github.com/altayhunoglu/algorithms/issues/62)
    "Approach #2 Single traversal" çözümü gayet anlaşılır ve hızlı.

 [Binary Tree Vertical Order Traversal](https://github.com/altayhunoglu/algorithms/issues/63)
    	
 Diğer birçok Tree sorusunda olduğu gibi, burada da derinlik öncelikli arama "Approach 3: Depth-First Search (DFS)" daha uygun görünüyor.

 [Meeting Rooms II](https://github.com/altayhunoglu/algorithms/issues/64)
  
 Standart çözümdeki "Approach 2: Chronological Ordering" yaklaşımı, zannedersem aynı zamanda en çok puanı almış olan çözüm ile aynı mantığı izliyor.

 [Bomb Enemy](https://github.com/altayhunoglu/algorithms/issues/65)

 Burada "Approach 2: Dynamic Programming" yaklaşımı uygundur.

 [Sentence Similarity II](https://github.com/altayhunoglu/algorithms/issues/66)

  Burada bize union-find kullanımını hatırlatması açısından "Approach #2: Union-Find" yaklaşımı iyidir. Standart çözümde birkaç değişiklik gerekiyordu. Liste yerine array kullanılmıştı, onu düzelttik.

 [Flatten 2D Vector](https://github.com/altayhunoglu/algorithms/issues/67)	
    	
  Approach 2: Two Pointers, yaklaşımı gayet kolay. Çözüm kısmında lâfı fazla uzatmışlar ama göründüğü kadar zor değil.

 [Verify Preorder Sequence in Binary Search Tree](https://github.com/altayhunoglu/algorithms/issues/68)
 
  Şuradaki en fazla puan alan çözüm uygundur:
 
  https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/discuss/68142/Java-O(n)-and-O(1)-extra-space

 [Longest Line of Consecutive One in Matrix](https://github.com/altayhunoglu/algorithms/issues/69)

   Standart çözümler pek beğenilmemiş. Şurada en iyi puanı alan Java kodu uygun görünüyor:
https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/discuss/102266/Java-O(nm)-Time-DP-Solution

 [Reverse Words in a String II](https://github.com/altayhunoglu/algorithms/issues/70)
  
 Standart çözüm uygun görünüyor:
"Approach 1: Reverse the Whole String and Then Reverse Each Word"
 	
 [Longest Substring with At Most K Distinct Characters](https://github.com/altayhunoglu/algorithms/issues/71)	
  
 Daha önce çözdüğümüz "159. Longest Substring with At Most Two Distinct Characters" sorusu ile neredeyse aynıdır. Çözüm de aynı şekilde pencere ve HashMap ile yapılacaktır.
   Bu yüzden "Approach 1: Sliding Window + Hashmap." uygundur.

 [Add Bold Tag in String](https://github.com/altayhunoglu/algorithms/issues/73)	
 
 Şuradaki çözüm zekice görünüyor:
https://leetcode.com/problems/add-bold-tag-in-string/discuss/104248/Java-Solution-boolean-array

 [Closest Leaf in a Binary Tree](https://github.com/altayhunoglu/algorithms/issues/74)	
 
   Binary Tree'yi önce bir Graf'a çevirmeyi öğrettiği için şu çözüm uygun görünüyor: Approach #1: Convert to Graph [Accepted]

 [Word Pattern II](https://github.com/altayhunoglu/algorithms/issues/75)	
 
   Daha önce öğrendiğimiz	"Backtracking" metodu kullandığı için, buradaki çözüm uygun görünüyor.
https://leetcode.com/problems/word-pattern-ii/discuss/73664/Share-my-Java-backtracking-solution

 [Find the Celebrity](https://github.com/altayhunoglu/algorithms/issues/76)	
 
   Standart çözümdeki "mantıksal çıkarım" yani "Approach 2: Logical Deduction" yöntemi uygun görünüyor.
	
 [Graph Valid Tree](https://github.com/altayhunoglu/algorithms/issues/77)
 
   Daha önceden bildiğimiz Union-find kullandığı için "Approach 3: Advanced Graph Theory + Union Find" çözümü uygundur.

 [Inorder Successor in BST](https://github.com/altayhunoglu/algorithms/issues/78)
 
   Bu bir binary search tree olduğu için, doğal olarak "Approach 2: Using BST properties" uygun çözümdür.

 [All Paths from Source Lead to Destination](https://github.com/altayhunoglu/algorithms/issues/78)	
 
 Standart çözüm: "Approach: Depth First Search" bize uygun görünüyor.
    	
 [Boundary of Binary Tree](https://github.com/altayhunoglu/algorithms/issues/79)
    
   Preorder sıralama, az çok burada istediği gibi, bir ağacı sarmalayarak ilerlediği için, en uygun çözüm doğal olarak: 
    Approach #2 Using PreOrder Traversal 

 [Maximum Distance in Arrays](https://github.com/altayhunoglu/algorithms/issues/80)
    
   Şuradaki çözüm, muhtemelen standart çözümde de kullanılmış:
https://leetcode.com/problems/maximum-distance-in-arrays/discuss/104613/Java-Solution-Min-and-Max

 [Paint Fence](https://github.com/altayhunoglu/algorithms/issues/81)

  Standart çözümdeki "Approach 2: Dynamic Programming 1D - Bottom Up" bize uygun görünüyor.

 [Largest BST Subtree](https://github.com/altayhunoglu/algorithms/issues/82)
    	
   Şuradaki çözüm uygun görünüyor:
     https://leetcode.com/problems/largest-bst-subtree/discuss/78899/Very-Short-Simple-Java-O(N)-Solution

 [Palindrome Permutation II](https://github.com/altayhunoglu/algorithms/issues/83)	
    		Backtracking kullanılan şu yöntem uygun görünüyor: "Approach #2 Backtracking"  

 [Minimum Knight Moves](https://github.com/altayhunoglu/algorithms/issues/84)
 
   Şuradaki çözümde her şey adım adım açıklanmış:
    https://leetcode.com/problems/minimum-knight-moves/discuss/392053/Here-is-how-I-get-the-formula-(with-graphs)
 
 [Design Snake Game](https://github.com/altayhunoglu/algorithms/issues/85)

   Standart çözüm gâyet uygun görünüyor.

 [One Edit Distance](https://github.com/altayhunoglu/algorithms/issues/86)

  Standart çözüm (Approach 1: One pass algorithm) gayet uygun görünüyor.

 [Encode and Decode Strings](https://github.com/altayhunoglu/algorithms/issues/87)
 
   Şuradaki çözüm en çok oy alanlar arasında ve gâyet anlaşılır görünüyor:
  https://leetcode.com/problems/encode-and-decode-strings/discuss/70412/AC-Java-Solution
 
 [Insert into a Sorted Circular Linked List](https://github.com/altayhunoglu/algorithms/issues/88)
   	Böyle Linked List sorularında, iki pointer kullanmak akla yatkın görünüyor:
   "Approach 1: Two-Pointers Iteration"


    	






 



 

