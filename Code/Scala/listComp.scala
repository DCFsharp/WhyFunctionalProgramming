
	// Scala 
	val numbers = List.range(1, 11)
	numbers filter (x => x % 3 == 0)
	numbers filter (_ % 3 == 0)
	// List(3, 6, 9)

	numbers partition (_ % 3 == 0)
	// (List(3, 6, 9),List(1, 2, 4, 5, 7, 8, 10))

	numbers find (_ % 3 == 0)
	// Some(3)

	List(1, 2, 3, 4, 5) map (_ + 1)
	// List(2, 3, 4, 5, 6)”

	List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9)) flatMap (_.toList)
	// List(1, 2, 3, 4, 5, 6, 7, 8, 9)”



	// Groovy
	(1..10).findAll {it % 3 == 0}
	// [3, 6, 9]
	
	def words = ["the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog"]
	words.findAll {it.length() == 3}
	// [The, fox, the, dog]

	(1..10).split {it % 3}
	// [ [1, 2, 4, 5, 7, 8, 10], [3, 6, 9] ]

	(1..10).find {it % 3 == 0}
	// 3

	(1..5).collect {it += 1}
	// [2, 3, 4, 5, 6]
	
	def words = ["the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog"]
	words.collect {it.length()}
	// [3, 5, 5, 3, 6, 4, 3, 4, 3]
	
	[ [1, 2, 3], [4, 5, 6], [7, 8, 9] ].flatten()
	// [1, 2, 3, 4, 5, 6, 7, 8, 9]”

