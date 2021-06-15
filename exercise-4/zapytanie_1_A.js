printjson(db.people.aggregate(
    [
        {
            $addFields: {
                convertedWeight: {$toDouble: "$weight"},
                convertedHeight: {$toDouble: "$height"}
            }
        },
        {
            $group: {
                _id: "$sex",
                avgWeight: {"$avg": "$convertedWeight"},
                avgHeight: {"$avg": "$convertedHeight"}
            }
        }
    ]
    ).toArray()
)
