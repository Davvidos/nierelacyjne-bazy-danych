printjson(db.people.mapReduce(
    function() {
        let bmi = parseFloat(this.weight) / Math.pow((parseFloat(this.height) / 100.0), 2);

        emit(
            this.nationality,
            {
                minBmi: bmi,
                max: bmi,
                total: bmi,
                count: 1
            }
        );
    },
    function(key, values) {
        let first_value = values[0];
        let result = {min: first_value.min, max: first_value.max, total: 0, count: 0};

        for (value of values) {
            result.count += value.count;
            result.total += value.total;
            result.min = Math.min(result.min, value.min);
            result.max = Math.max(result.max, value.max);
        }

        return result;
    },
    {
        out: {
            inline: 1
        },
        finalize: function(key, value) {
            return {
                nationality: key,
                min: value.min,
                max: value.max,
                avg: value.total / value.count
            }
        }
    }
).results);
