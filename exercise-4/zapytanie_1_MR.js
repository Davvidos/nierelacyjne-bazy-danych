const mapFunction = function () {
    let key = this.sex;
    let value = {
        avgWeight: parseFloat(this.weight),
        avgHeight: parseFloat(this.height),
        count: 1
    };

    return emit(key, value);
};

const reduceFunction = function (key, value) {
    return {
        avgWeight: Array.sum(
            value.map(obj => obj.avgWeight)
        ),
        avgHeight: Array.sum(
            value.map(obj => obj.avgHeight)
        ),
        count: Array.sum(
            value.map(obj => obj.count)
        )
    };
};

const finalizeFunction = function (key, reducedVal) {
    return {
        avgWeight: reducedVal.avgWeight / reducedVal.count,
        avgHeight: reducedVal.avgHeight / reducedVal.count
    };
};

printjson(db.people.mapReduce(mapFunction, reduceFunction, {
    out: {
        inline: 1
    },
    finalize: finalizeFunction
}));
