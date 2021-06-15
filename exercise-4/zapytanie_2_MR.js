const mapFunction = function () {
    this.credit.forEach(credit => {
        let key = credit.currency;
        let value = parseFloat(credit.balance);

        emit(key, value);
    });
};

const reduceFunction = function (key, values) {
    return Array.sum(values);
};

printjson(db.people.mapReduce(mapFunction, reduceFunction, {
    out: {
        inline: 1
    }
}));
