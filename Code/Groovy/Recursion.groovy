def filter(list, pred){
	def filteredList = []
	list.each{ n ->
		if pred(n)
			filteredList.add(n)
	}
	filteredList
}

// Recursive Filtering with Groovy
def filterR(list, pred) {
    if (list.size() == 0) return list
    if (pred(list.head()))
        [] + list.head() + filterR(list.tail(), pred)
    else
        filterR(list.tail(), pred)
}

println "Recursive Filtering"
println filterR(1..20, {it % 2 == 0})
// [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]

