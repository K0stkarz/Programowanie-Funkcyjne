const { app } = require('@azure/functions');

app.http('CheckPrime', {
    methods: ['GET', 'POST'],
    authLevel: 'anonymous',
    handler: async (request, context) => {
        let numberVal = request.query.get('number');
        
        if (!numberVal) {
            try {
                const body = await request.json();
                numberVal = body.number;
            } catch (e) {}
        }

        const number = parseInt(numberVal);

        if (isNaN(number) || number < 2) {
            return { jsonBody: { number: number, result: 0 } };
        }

        let isPrime = 1;
        for (let i = 2; i <= Math.sqrt(number); i++) {
            if (number % i === 0) {
                isPrime = 0;
                break;
            }
        }

        return { jsonBody: { number: number, isPrime: isPrime } };
    }
});
