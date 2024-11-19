const list = [1, 2, 3];

// pfeilfunktion ohne parameter

const example = () => {
    // Code ...
    const result = 'example';
    return result;
}

console.log(example());


// Pfeilfunktion mit einem Parameter
const listDoubled = list.map((number) =>result * 2);

console.log(listDoubled);


// - bei einem parameter können die runden Klammern weggeslassen werden
// - return keyword + {} weggelassen und
//  lediglich den return reigeschrieben 