const { app } = require('@azure/functions');

app.http('Factorial', {
    methods: ['GET', 'POST'],
    authLevel: 'anonymous',
    handler: async (request, context) => {
        let nVal = request.query.get('n');
        
        if (!nVal) {
            try {
                const body = await request.json();
                nVal = body.n;
            } catch (e) {}
        }

        const n = parseInt(nVal);

        if (isNaN(n) || n < 0) {
            return { status: 400, jsonBody: { error: "Podaj liczbę n > 0" } };
        }

        const silnia = (num) => (num <= 1 ? 1 : num * silnia(num - 1));

        return { jsonBody: { input: n, result: silnia(n) } };
    }
});
