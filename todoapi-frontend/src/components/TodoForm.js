import React from 'react';

class TodoForm extends React.Component {
    
    constructor() {
        super();

        this.state = {
            todoItem: {
                name: '',
                completed: false
            },

            createdEntityLocation: ''
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState(
            { todoItem: { 
                name : event.target.value
            }}
        );
    }

    handleSubmit(event) {
        event.preventDefault();         

        const todoItem = this.state.todoItem;
        
        if (todoItem.name.length === 0) {
            return;
        }

        // CONSOLE LOG
        console.log(todoItem);

        fetch("http://localhost:8080/api/todo-items/", {
            method: 'POST',
            headers: { 
                'Content-Type' : 'application/json'
             },
            body: JSON.stringify(todoItem),
        }).then((response) => {
            console.log(response.headers.get('location'));
        })


    }

    render() {
        return(
            <div>
                <form onSubmit={this.handleSubmit}>
                    Name: <input id="nameInput" type="text" value={this.state.todoItem.name} onChange={this.handleChange} />                           
                    <input type="submit" value="Add" />
                </form>
            </div>
        );
    };
};

export default TodoForm;