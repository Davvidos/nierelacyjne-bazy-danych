printjson(db.people.aggregate(
    [
        {
            $addFields: {
                convertedWeight: {
                    $toDouble: "$weight"
                },
                convertedHeight: {
                    $toDouble: "$height"
                }
            }
        },
        {
            $addFields: {
                convertedHeightInMeters: {
                    $divide: ["$convertedHeight", 100]
                }
            }
        },
        {
            $addFields: {
                bmi: {
                    $divide: [
                        "$convertedWeight",
                        {
                            $multiply: ["$convertedHeightInMeters", "$convertedHeightInMeters"]
                        }
                    ]
                }
            }
        },
        {
            $group: {
                _id: "$nationality",
                minBmi: {
                    $min: "$bmi"
                },
                avgBmi: {
                    $avg: "$bmi"
                },
                maxBmi: {
                    $max: "$bmi"
                }
            }
        },
        {$sort: {
            _id: 1}
        }
    ]
    ).toArray()
)
