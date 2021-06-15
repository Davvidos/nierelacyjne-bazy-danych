printjson(db.people.mapReduce(
    function() {
        if (this.sex !== "Female" || this.nationality !== "Poland") {
            return;
        }
        for (card of this.credit) {
            emit(
                card.currency,
                {
                    total: parseFloat(card.balance),
                    count: 1
                }
            );
        }
    },
    function(key, values) {
        let x = {
            total: 0,
            count: 0
        };

        for (value of values) {
            x.total += value.total;
            x.count += 1;
        }

        return x;
    },
    {
        out: {
            inline: 1
        },

        finalize: function(key, value) {
            return {
                currency: key,
                total: value.total,
                average: value.total / value.count
            }
        }
    }
).results);
