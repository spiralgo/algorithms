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

[369. Plus One Linked List](https://github.com/altayhunoglu/algorithms/issues/22)

Bu soruda standart çözüm gayet uygun ve anlaşılır görünüyor:
Approach 1: Sentinel Head + Textbook Addition.

[281. Zigzag Iterator](https://github.com/altayhunoglu/algorithms/issues/23)

Burada kuyruk kullanılan Approach 2: Queue of Pointers, daha anlaşılır ve profesyonel görünüyor. 


[1135. Connecting Cities With Minimum Cost](https://github.com/altayhunoglu/algorithms/issues/24)

Bu gibi minimum-maksimum istenen sorularda genellik Greedy strateji uygulanır. Yani, neticenin gerçekten de maksimum-minimum olup olmadığına bakılmaksızın, yerel olarak
eldeki verilerden en uygun görünen ilkleri seçilerek işleme devam edilir.
 Böyle en düşük maliyetle şehir birleştirme sorularında standart olarak Kruskal algoritması kullanılır. Çünkü, Kruskal, bir graftaki minimum-spanning tree denilen, en az mâliyetli ağacı bukmak için kullanılan bir algoritmadır. (Prim's Algorithm gibi)
 Kruskal bize çok yabancı gelmeyecektir çünkü kendi içinde "arkadaş grubu" probleminden hatırladığımız 
 Union-Find veriyapısını kullanıyor.
 
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
    	 
 [Walls and Gates](https://github.com/altayhunoglu/algorithms/issues/35)
    	 
 [Shortest Word Distance III](https://github.com/altayhunoglu/algorithms/issues/36)
    	 
 [Design Tic-Tac-Toe](https://github.com/altayhunoglu/algorithms/issues/37)
    		 
 [Missing Element in Sorted Array](https://github.com/altayhunoglu/algorithms/issues/38)
     
 [Find the Index of the Large Integer](https://github.com/altayhunoglu/algorithms/issues/39)
    		 
 [Meeting Scheduler](https://github.com/altayhunoglu/algorithms/issues/40)
    		 
 [Shortest Word Distance II](https://github.com/altayhunoglu/algorithms/issues/41)
    	 
 [Campus Bikes II](https://github.com/altayhunoglu/algorithms/issues/42)
    	 
 [Generalized Abbreviation](https://github.com/altayhunoglu/algorithms/issues/43)
     
 [Paint House](https://github.com/altayhunoglu/algorithms/issues/44)
    		 
 [Shortest Distance to Target Color](https://github.com/altayhunoglu/algorithms/issues/45)
  		 
 [Count Univalue Subtrees](https://github.com/altayhunoglu/algorithms/issues/46)
    		 
 [4 Keys Keyboard](https://github.com/altayhunoglu/algorithms/issues/47)
    		 	
 [The Maze](https://github.com/altayhunoglu/algorithms/issues/48)
    	 
 [Construct Binary Tree from String](https://github.com/altayhunoglu/algorithms/issues/49)
    		 
 [Path With Maximum Minimum Value](https://github.com/altayhunoglu/algorithms/issues/50)
    		 
 [Longest Substring with At Most Two Distinct Characters](https://github.com/altayhunoglu/algorithms/issues/51)
    		 
 [Sort Transformed Array](https://github.com/altayhunoglu/algorithms/issues/51)
    		 	
 [First Unique Number](https://github.com/altayhunoglu/algorithms/issues/53)
    		 
 [Leftmost Column with at Least a One](https://github.com/altayhunoglu/algorithms/issues/54)
    	 
 [3Sum Smaller](https://github.com/altayhunoglu/algorithms/issues/55)
    	 
 [Strobogrammatic Number II](https://github.com/altayhunoglu/algorithms/issues/57)
    		 
  
 [The Maze II](https://github.com/altayhunoglu/algorithms/issues/56)	
    
 [Binary Tree Longest Consecutive Sequence](https://github.com/altayhunoglu/algorithms/issues/58)
   	
 [Max Consecutive Ones II](https://github.com/altayhunoglu/algorithms/issues/59)
  
 [Factor Combinations](https://github.com/altayhunoglu/algorithms/issues/60)	
    		
 [Maximum Size Subarray Sum Equals k](https://github.com/altayhunoglu/algorithms/issues/61)
    	
 [Binary Tree Longest Consecutive Sequence II](https://github.com/altayhunoglu/algorithms/issues/62)
    
 [Binary Tree Vertical Order Traversal](https://github.com/altayhunoglu/algorithms/issues/63)
    	
 [Meeting Rooms II](https://github.com/altayhunoglu/algorithms/issues/64)
    
 [Bomb Enemy](https://github.com/altayhunoglu/algorithms/issues/65)
    	
 [Sentence Similarity II](https://github.com/altayhunoglu/algorithms/issues/66)
    	
 [Flatten 2D Vector](https://github.com/altayhunoglu/algorithms/issues/67)	
    	
 [Verify Preorder Sequence in Binary Search Tree](https://github.com/altayhunoglu/algorithms/issues/68)
    	
 [Longest Line of Consecutive One in Matrix](https://github.com/altayhunoglu/algorithms/issues/69)
    	
 [Reverse Words in a String II](https://github.com/altayhunoglu/algorithms/issues/70)
    	
 [Longest Substring with At Most K Distinct Characters](https://github.com/altayhunoglu/algorithms/issues/71)	
    
 [Add Bold Tag in String](https://github.com/altayhunoglu/algorithms/issues/73)	
    		
 [Closest Leaf in a Binary Tree](https://github.com/altayhunoglu/algorithms/issues/74)	
    		
 [Word Pattern II](https://github.com/altayhunoglu/algorithms/issues/75)	
    	
 [Find the Celebrity](https://github.com/altayhunoglu/algorithms/issues/76)	
     		
 [Graph Valid Tree](https://github.com/altayhunoglu/algorithms/issues/77)
    		
 [Inorder Successor in BST](https://github.com/altayhunoglu/algorithms/issues/78)
    		
 [All Paths from Source Lead to Destination](https://github.com/altayhunoglu/algorithms/issues/78)	
    	
 [Boundary of Binary Tree](https://github.com/altayhunoglu/algorithms/issues/79)
    	
 [Maximum Distance in Arrays](https://github.com/altayhunoglu/algorithms/issues/80)
    	
 [Paint Fence](https://github.com/altayhunoglu/algorithms/issues/81)
   	
 [Largest BST Subtree](https://github.com/altayhunoglu/algorithms/issues/82)
    	
 [Palindrome Permutation II](https://github.com/altayhunoglu/algorithms/issues/83)	
    		
 [Minimum Knight Moves](https://github.com/altayhunoglu/algorithms/issues/84)
    		
 [Design Snake Game](https://github.com/altayhunoglu/algorithms/issues/85)
    		
 [One Edit Distance](https://github.com/altayhunoglu/algorithms/issues/86)
    		
 [Encode and Decode Strings](https://github.com/altayhunoglu/algorithms/issues/87)
    		
 [Insert into a Sorted Circular Linked List](https://github.com/altayhunoglu/algorithms/issues/88)
   	
 [Encode N-ary Tree to Binary Tree](https://github.com/altayhunoglu/algorithms/issues/89)
    		
 [Robot Room Cleaner](https://github.com/altayhunoglu/algorithms/issues/90)	
    	
 [Employee Free Time](https://github.com/altayhunoglu/algorithms/issues/91)	
    	
 [Number of Ships in a Rectangle](https://github.com/altayhunoglu/algorithms/issues/92)	
    	






 



 

