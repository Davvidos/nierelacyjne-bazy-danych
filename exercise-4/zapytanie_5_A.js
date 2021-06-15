printjson(
    db.people.aggregate(
        [
            {
                $match: {
                    sex: "Female",
                    nationality: "Poland"
                }
            },
            {
                "$addFields": {
                    credit: {
                        "$map": {
                            input: "$credit",
                            in: {
                                "$mergeObjects": [
                                    "$$this",
                                    {
                                        "convertedBalance": {
                                            "$toDecimal": "$$this.balance"
                                        }
                                    }
                                ]
                            }
                        }
                    }
                }
            },
            {
                $unwind: "$credit"
            },
            {
                $group: {
                    _id: "$credit.currency",
                    total: {
                        $sum: "$credit.convertedBalance"
                    },
                    average: {
                        $avg: "$credit.convertedBalance"
                    }
                }
            },
            {
                $sort: {
                    _id: 1
                }
            }
        ]
    ).toArray()
)
