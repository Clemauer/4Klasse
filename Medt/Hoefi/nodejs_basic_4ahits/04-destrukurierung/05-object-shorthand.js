const address = {
    firstName: 'Eduard',
    lastName: 'Müller',
    street: 'Anton Ehrenfried-Straße',
    housenr: 10,
    zipCode: 2020,
    city: 'Hollarbunn'
};

const {firstName, lastName, street, housenr, zipCode, city} = address;

/*
const address2 = {
    firstName: firstName,
    lastName: lastName,
    street: street,
    housenr: housenr,
    zipCode: zipCode,
    city: city
};
*/

const address2 = {
    firstName,
    lastName,
    street,
    housenr,
    zipCode,
    city
};
