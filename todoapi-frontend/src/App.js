import React from 'react';
import TodoList from './components/TodoList';
import TodoForm from './components/TodoForm';

class App extends React.Component {

  state = {
    todos: []
  }

  componentDidMount() {
    fetch("http://localhost:8080/api/todo-items")
      .then(res => res.json())
      .then((data) => {
        this.setState({ todos: data });
      })
      .catch(console.log)
  }

  render() {
    return (
      <div>
        <center><h1>Todo List</h1></center>
        <TodoForm />
        <TodoList todos={this.state.todos} />
      </div>
    );
  }
}

export default App;
