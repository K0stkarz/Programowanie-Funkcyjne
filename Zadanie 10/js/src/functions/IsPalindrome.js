const { app } = require('@azure/functions');

app.http('IsPalindrome', {
    methods: ['GET', 'POST'],
    authLevel: 'anonymous',
    handler: async (request, context) => {
        let text = request.query.get('text');

        if (!text) {
             try {
                const body = await request.json();
                text = body.text;
            } catch (e) {}
        }

        const cleanText = text.replace(/[^a-zA-Z0-9]/g, '').toLowerCase();
        const reversed = cleanText.split('').reverse().join('');
        const isPal = cleanText === reversed;

        return { jsonBody: { input: text, isPalindrome: isPal } };
    }
});
