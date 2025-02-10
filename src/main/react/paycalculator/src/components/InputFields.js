import React, { useState } from 'react';

function InputFields({ onInputChange, isLoading }) {
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

    const getDaysOfWeekArray = () => {
        return [
        daysOfWeek.Monday,
        daysOfWeek.Tuesday,
        daysOfWeek.Wednesday,
        daysOfWeek.Thursday,
        daysOfWeek.Friday,
        daysOfWeek.Saturday,
        daysOfWeek.Sunday,
        ];
    };

    const handleSubmit = (event) => {
        event.preventDefault();

        const formattedPayPeriod = {
            year: parseInt(year, 10),
            month:parseInt(month,10),
            hourlyRate:parseFloat(hourlyRate),
            hoursWorkedPerDay:parseFloat(hoursWorkedPerDay),
            extraHours:parseFloat(extraHours),
            daysOfWeek: getDaysOfWeekArray(),
        };

        onInputChange(formattedPayPeriod);

    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="year">Insert year: </label>
                <input
                    type="number"
                    id="year"
                    name="year"
                    value={year}
                    onChange={handleInputChange}
                />
            </div>

            <div>
                <label htmlFor="month">Insert month: </label>
                <input
                    type="number"
                    id="month"
                    name="month"
                    value={month}
                    onChange={handleInputChange}
                />
            </div>

            <div>
                <label htmlFor="hourlyRate">Insert hourly rate: </label>
                <input
                    type="number"
                    id="hourlyRate"
                    name="hourlyRate"
                    value={hourlyRate}
                    onChange={handleInputChange}
                />
            </div>

            <div>
                <label htmlFor="hoursWorked">Insert hours worked per day: </label>
                <input
                    type="number"
                    id="hoursWorkedPerDay"
                    name="hoursWorkedPerDay"
                    value={hoursWorkedPerDay}
                    onChange={handleInputChange}
                />
            </div>

            <div>
                <label htmlFor="extraHours">Extra hours to add or deduct: </label>
                <input
                    type="number"
                    id="extraHours"
                    name="extraHours"
                    value={extraHours}
                    onChange={handleInputChange}
                />
            </div>
            <div>
                    {["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "All", "Weekdays"].map((day) => (
                      <label key={day}>
                        <input
                          type="checkbox"
                          name={day}
                          checked={daysOfWeek[day]}
                          onChange={handleCheckboxChange}
                        />
                        {day}
                      </label>
                    ))}
                  </div>
                  <button type="submit" disabled={isLoading}>
                    {isLoading ? 'Calculating...' : 'Calculate'}
                  </button>
                </form>
              );
            }

            export default InputFields;
