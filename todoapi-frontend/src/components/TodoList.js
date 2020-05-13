import React from 'react';

const TodoList = ({ todos }) => {
    return (
        <div>            
            {todos.map((todo) => (
                <div key={todo.id} className="card">
                    <div className="card-body">
                        <h5 className="card-title">{todo.name}</h5>
                        <p className="card-text">{todo.complete ? "Completed" : ""}</p>
                    </div>
                </div>
            ))}
        </div>
    )
};

export default TodoList;