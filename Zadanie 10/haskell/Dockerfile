FROM haskell:9.6-slim

WORKDIR /app

RUN apt-get update && apt-get install -y \
    zlib1g-dev \
    && rm -rf /var/lib/apt/lists/*

COPY Zadanie10.cabal .
COPY LICENSE .
COPY CHANGELOG.md .

RUN cabal update && cabal build --only-dependencies

COPY app ./app

RUN cabal build

RUN cabal install --installdir=. --install-method=copy

EXPOSE 3000

CMD ["./Zadanie10"]