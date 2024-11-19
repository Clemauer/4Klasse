const address = {
    firstName: 'Eduard',
    lastName: 'Müller',
    street: 'Anton Ehrenfried-Straße',
    housenr: 10,
    zipCode: 2020,
    city: 'Hollarbunn'
};

const contact = {
    firstName: 'Eduard',
    lastName: 'Müller',
    email: `eduard.mueller@htl-hl.ac.at`,
    phone: `+4329523361`
};

const person = { ... address, ...contact, country: `Austria`};
console.log(person);

