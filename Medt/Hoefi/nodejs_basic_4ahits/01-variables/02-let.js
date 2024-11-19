// Nachteile der Variablendeklaration mit let

function varProblems(){
    let myVariable = 1234;

    /*
    a lot of code
    */

    if (true){
        let myVariable = 4321;
    }

    console.log(myVariable); // 1234 oder 4321?
}

varProblems();