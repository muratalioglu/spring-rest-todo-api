import React from 'react';
import TodoList from './components/TodoList';

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
      <TodoList todos={this.state.todos} />
    );
  }
}

export default App;
