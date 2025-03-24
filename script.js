const API_URL = "http://localhost:8080/tasks";

async function fetchTasks() {
    const response = await fetch(API_URL);
    const tasks = await response.json();
    const taskList = document.getElementById("taskList");
    taskList.innerHTML = "";
    tasks.forEach(task => {
        const li = document.createElement("li");
        li.innerHTML = `${task.title} <button onclick="deleteTask(${task.id})">Delete</button>`;
        taskList.appendChild(li);
    });
}

async function addTask() {
    const title = document.getElementById("taskTitle").value;
    if (title.trim() === "") return;
    
    await fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ title })
    });

    document.getElementById("taskTitle").value = "";
    fetchTasks();
}

async function deleteTask(id) {
    await fetch(`${API_URL}/${id}`, { method: "DELETE" });
    fetchTasks();
}

document.addEventListener("DOMContentLoaded", fetchTasks);
