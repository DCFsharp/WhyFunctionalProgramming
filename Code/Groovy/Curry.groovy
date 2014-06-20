// Groovy implements currying through the curry() function

def product = { x, y -> x * y }

def quadrate = product.curry(4)
def octate = product.curry(8)

println "4x4: ${quadrate.call(4)}"
println "5x8: ${octate(5)}"

// curry() fixes one parameter, returning a function that accepts a single parameter
// the octate() function always multiples the passed parameter by 8


// Partial application vs. currying in Groovy
def volume = {h, w, l -> h * w * l}
def area = volume.curry(1)
def lengthPA = volume.curry(1, 1) // partial application
def lengthC = volume.curry(1).curry(1)  // currying

println "The volume of the 2x3x4 rectangle is ${volume(2, 3, 4)}"
println "The area of the 3x4 square is ${area(3, 4)}"
println "The length of the 6 line is ${lengthPA(6)}"
println "The length of the 6 line via curried function is ${lengthC(6)}"
