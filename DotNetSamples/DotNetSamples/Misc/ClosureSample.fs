namespace Misc

module closure =
// clousre sample in F#
    let makeCounter() =
        let localVal = ref 0
        let makeCounter() =
            localVal := !localVal + 1
            !localVal 
        makeCounter



    let c1 = makeCounter()
    c1()
    c1()
    c1()

    let c2 = makeCounter()

    printfn "C1 = %d, C2 = %d" (c1()) (c2())