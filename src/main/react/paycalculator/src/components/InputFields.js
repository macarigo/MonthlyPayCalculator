import React, { useState } from 'react';

function InputFields({ onInputChange }) {
    const [year, setYear] = useState ('');
    const [month, setMonth] = useState ('');
    const [hourlyRate, setHourlyRate] = useState ('');
    const [hoursWorkedPerDay, setHoursWorkedPerDay] = useState ('');
    const [extraHours, setExtraHours] = useState ('');

    const [daysOfWeek, setDaysOfWeek] = useState ({
        "Monday": false,
        "Tuesday": false,
        "Wednesday": false,
        "Thursday": false,
        "Friday": false,
        "Saturday": false,
        "Sunday": false,
        "All": false,
        "Weekdays": false
        });

    const handleInputChange = (event) => {
        const {name, value } = event.target;
        switch (name) {
        case "year":
            setYear(value);
            break;
        case "month":
            setMonth(value);
            break;
        case "hourlyRate":
            setHourlyRate(value);
            break;
        case "hoursWorkedPerDay":
            setHoursWorkedPerDay(value);
            break;
        case "extraHours":
            setExtraHours(value);
            break;
        default:
            break;
        }
    };

    const handleCheckboxChange = (event) => {
        const { name } = event.target;

        if (name === "All") {
            setDaysOfWeek ({
            "Monday": true,
            "Tuesday": true,
            "Wednesday": true,
            "Thursday": true,
            "Friday": true,
            "Saturday": true,
            "Sunday": true,
            "All": !daysOfWeek.All,
            "Weekdays": false
            });
        } else if (name === "Weekdays") {
            setDaysOfWeek({
                "Monday": true,
                "Tuesday": true,
                "Wednesday": true,
                "Thursday": true,
                "Friday": true,
                "Saturday": false,
                "Sunday": false,
                "All": false,
                "Weekdays": !daysOfWeek.Weekdays
            });
        } else {
            setDaysOfWeek ({
                ...daysOfWeek,
                [name]: !daysOfWeek[name]
            });
        }
    };

    return (
        <div>
            <label htmlFor="year">Insert year: </label>
            <input
                type="number"
                id="year"
                name="year"
                value={year}
                onChange={handleInputChange}
            />

            <label htmlFor="month">Insert month: </label>
            <input
                type="number"
                id="month"
                name="month"
                value={month}
                onChange={handleInputChange}
            />

            <label htmlFor="hourlyRate">Insert hourly rate: </label>
            <input
                type="number"
                id="hourlyRate"
                name="hourlyRate"
                value={hourlyRate}
                onChange={handleInputChange}
            />

            <label htmlFor="hoursWorked">Insert hours worked per day: </label>
            <input
                type="number"
                id="hoursWorkedPerDay"
                name="hoursWorkedPerDay"
                value={hoursWorkedPerDay}
                onChange={handleInputChange}
            />

            <label htmlFor="extraHours">Extra hours to add or deduct: </label>
            <input
                type="number"
                id="extraHours"
                name="extraHours"
                value={extraHours}
                onChange={handleInputChange}
            />

            <div>
                <label>
                    <input
                        type="checkbox"
                        name="Monday"
                        checked={daysOfWeek.Monday}
                        onChange={handleCheckboxChange}
                    />
                    Monday
                </label>
            </div>

            <div>
                <label>
                    <input
                        type="checkbox"
                        name="Tuesday"
                        checked={daysOfWeek.Tuesday}
                        onChange={handleCheckboxChange}
                    />
                    Tuesday
                </label>
            </div>

            <div>
                <label>
                    <input
                        type="checkbox"
                        name="Wednesday"
                        checked={daysOfWeek.Wednesday}
                        onChange={handleCheckboxChange}
                    />
                    Wednesday
                </label>
            </div>

            <div>
                <label>
                    <input
                        type="checkbox"
                        name="Thursday"
                        checked={daysOfWeek.Thursday}
                        onChange={handleCheckboxChange}
                    />
                    Thursday
                </label>
            </div>

            <div>
                <label>
                    <input
                        type="checkbox"
                        name="Friday"
                        checked={daysOfWeek.Friday}
                        onChange={handleCheckboxChange}
                    />
                    Friday
                </label>
            </div>

            <div>
                <label>
                    <input
                        type="checkbox"
                        name="Saturday"
                        checked={daysOfWeek.Saturday}
                        onChange={handleCheckboxChange}
                    />
                    Saturday
                </label>
            </div>

            <div>
                <label>
                    <input
                        type="checkbox"
                        name="Sunday"
                        checked={daysOfWeek.Sunday}
                        onChange={handleCheckboxChange}
                    />
                    Sunday
                </label>
            </div>

            <div>
                <label>
                    <input
                        type="checkbox"
                        name="All"
                        checked={daysOfWeek.All}
                        onChange={handleCheckboxChange}
                    />
                    All
                </label>
            </div>

            <div>
                <label>
                    <input
                        type="checkbox"
                        name="Weekdays"
                        checked={daysOfWeek.Weekdays}
                        onChange={handleCheckboxChange}
                    />
                    Weekdays
                    </label>
            </div>
        </div>
    );
}

export default InputFields;