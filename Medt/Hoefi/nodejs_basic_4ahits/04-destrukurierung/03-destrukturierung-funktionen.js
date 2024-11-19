const address = {
    firstName: 'Eduard',
    lastName: 'Müller',
    street: 'Anton Ehrenfried-Straße',
    housenr: 10,
    zipCode: 2020,
    city: 'Hollarbunn'
};

function printAddress({firstName, lastName, street, housenr, zipCode, city}){
    console.log(`${firstName} ${lastName} 
${street} ${housenr} 
${zipCode} ${city}`);
};