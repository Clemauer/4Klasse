const contact = {
    firstName: 'Eduard',
    lastName: 'Müller',
    email: `eduard.mueller@htl-hl.ac.at`,
    phone: `+4329523361`
};

const {email, ...rest} = contact;
console.log(email);
console.log(rest);

function printNumbers(...numbers) {
    numbers.forEach(x => console.log(x))
};

printNumbers(1, 2, 3);