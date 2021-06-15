const mapFunction = function () {
    emit(this.job, this.job);
};

const reduceFunction = function (key, values) {
    return values[0];
};

printjson(db.people.mapReduce(mapFunction, reduceFunction, {
    out: {
        inline: 1
    }
}));
