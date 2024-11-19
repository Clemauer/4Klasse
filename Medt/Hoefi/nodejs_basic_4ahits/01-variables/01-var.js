// Nachteile der Variablendeklaration mit var

function varProblems(){
    var myVariable = 1234;

    /*
    a lot of code
    */

    if (true){
        var myVariable = 4321;
    }

    console.log(myVariable); // 1234 oder 4321?
}

varProblems();