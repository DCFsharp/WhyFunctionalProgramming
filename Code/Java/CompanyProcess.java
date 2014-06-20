// Given a list of names, some of which consist of a single character, 
// return a comma-delimited string with the single letter names removed, 
// with each name capitalized

val employees = List("neal", "s", "stu", "j", "rich", "bob", "aiden", "j", "ethan",
         "liam", "mason", "noah", "lucas", "jacob", "jayden", "jack")

public class TheCompanyProcess {
    public String cleanNames(List<String> listOfNames) {
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < listOfNames.size(); i++) {
        
            if (listOfNames.get(i).length() > 1) {
                result.append(capitalizeString(listOfNames.get(i))).append(",");
            }
        }
        return result.substring(0, result.length() - 1).toString();
    }

    public String capitalizeString(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }
}

/*  Because you must process the entire list, 
    the easiest way is to  use an imperative loop. 
    For each name, I check to see if it’s length 
    is greater than the disallowed single character, 
    then append the capitalized name onto result, 
    along with a trailing comma. 

    Imperative programming encourages developers to perform 
    operations within loops. 
    I do three things:  filter the list to eliminate single characters, 
                        transform the list to capitalize each name, 
                        convert the list into a single string. 
*/

// In Functional Programming, the action of filtering, transforming and converting 
// are represented as functions that implement the low-level transformation

// Scala
val result = employees
  // .par // to run in parallel  
  .filter(_.length() > 1)
  .map(_.capitalize)
  .reduce(_ + "," + _)


// Java 8 has these same features as Scala
public String cleanNames(List<String> names) {
        
        if (names == null) return "";
        
        return names
                .stream()  // .parallelStream() // to run in parallel
                .filter(name -> name.length() > 1)
                .map(name -> capitalize(name))
                .collect(Collectors.joining(","));  // I use the collect() method rather 
                                                    // than reduce() because it is more efficient with Java’s String class”
    }

    private String capitalize(String e) {
        return e.substring(0, 1).toUpperCase() + e.substring(1, e.length());
    }

// Groovy 
public static String cleanUpNames(listOfNames) {
    listOfNames
        .findAll { it.length() > 1 }
        .collect { it.capitalize() }
        .join ','
}

