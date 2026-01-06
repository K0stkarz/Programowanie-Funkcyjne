const express = require('express');
const app = express();
const PORT = 3000;

app.use(express.json());

const checkIfPrime = (n) => {
    return new Promise((resolve) => {
        const number = parseInt(n);

        if (isNaN(number)) {
            resolve(0);
            return;
        }

        if (number < 2) {
            resolve(0);
            return;
        }

        for (let i = 2; i <= Math.sqrt(number); i++) {
            if (number % i === 0) {
                resolve(0);
                return;
            }
        }

        resolve(1); 
    });
};

app.post('/first', (req, res) => {
    const inputNumber = req.body.number;

    checkIfPrime(inputNumber)
        .then((result) => {
            res.json({
                result: result
            });
        })
        .catch(() => {
            res.json({ result: 0 });
        });
});

app.listen(PORT, () => {
    console.log(`Server is running on port: ${PORT}`);
});
