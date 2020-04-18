import React from 'react';

const TodoList = ({ todos }) => {
    return (
        <div>
            <center><h1>Todo List</h1></center>
            {todos.map((todo) => (
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">{todo.name}</h5>
                        <p class="card-text">{todo.complete ? "Completed" : ""}</p>
                    </div>
                </div>
            ))}
        </div>
    )
};

export default TodoList;