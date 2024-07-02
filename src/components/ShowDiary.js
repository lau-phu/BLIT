import React, { useState, useEffect } from "react";
import '../style.css';
import { getDiary } from "../service/apiService"
import { login } from "../service/apiService";

export default DiaryGrid;




function DiaryGrid(data) {

    const [diary, setDiary] = useState([]); //user state hook : set variable

    ;
    //user effect hook - load data
    // useEffect(() => {
    //     fetch("data.json") //async call
    //         .then(response => response.json())
    //         .then(data => setDiary(data));
    // })

    // useEffect(() => {
    //     login('lorem','lorem')
    //         .then((response) => {
    //             setDiary(response.data);
    //         })
    //         .catch((err) => {
    //             console.log(err);
    //         })
    // }, []);

    setDiary(data)

    return (
        <div className="diary-grid">
            {
                diary.map(data => (
                    <div class="diary-data" key={data.id}>
                        <div class="row">
                            <div class="box1">
                                <img class="image" src={`image/${data.image}`} alt={data.title}></img>
                                <span class="name">{data.name}</span>
                            </div>
                            <div class="box2">
                                <div class="text">{data.entry}</div>
                            </div>
                        </div>
                    </div>
                ))

                // <div class="diary-data" key={data.id}>
                //     <div class="row">
                //         <div class="box1">
                //             <img class="image" src={`image/${data.image}`} alt={data.title}></img>
                //             <span class="name">{data.name}</span>
                //         </div>
                //         <div class="box2">
                //             <div class="text">{data.entry}</div>
                //         </div>
                //     </div>
                // </div>
            }
        </div>
    )
}