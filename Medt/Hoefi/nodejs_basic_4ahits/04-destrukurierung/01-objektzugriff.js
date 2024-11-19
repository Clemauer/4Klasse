const address = {
    firstName: 'Eduard',
    lastName: 'Müller',
    street: 'Anton Ehrenfried-Straße',
    housenr: 10,
    zipCode: 2020,
    city: 'Hollarbunn'
};

console.log(address)

// Zugriff auf objekteigenschaften
const firstName = address.firstName;
console.log(`name: ${firstName} ${address.lastName}`);