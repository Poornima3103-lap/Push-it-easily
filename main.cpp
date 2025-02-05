#include <iostream>
#include <vector>
#include <string>

using namespace std;

struct Task {
    string name;
    bool completed;
};

vector<Task> tasks; // Vector to store tasks

// Function to display the menu
void displayMenu() {
    cout << "\nTo-Do List Menu:" << endl;
    cout << "1. View Tasks" << endl;
    cout << "2. Add Task" << endl;
    cout << "3. Delete Task" << endl;
    cout << "4. Mark Task as Completed" << endl;
    cout << "5. Exit" << endl;
}

// Function to view tasks
void viewTasks() {
    if (tasks.empty()) {
        cout << "Your to-do list is empty!" << endl;
    } else {
        for (int i = 0; i < tasks.size(); ++i) {
            cout << i + 1 << ". " << tasks[i].name << " - "
                 << (tasks[i].completed ? "Completed" : "Pending") << endl;
        }
    }
}

// Function to add a task
void addTask() {
    string taskName;
    cout << "Enter the task description: ";
    cin.ignore(); // To clear the buffer
    getline(cin, taskName);
    tasks.push_back({taskName, false});
    cout << "Task '" << taskName << "' added!" << endl;
}

// Function to delete a task
void deleteTask() {
    viewTasks();
    int taskIndex;
    cout << "Enter the task number to delete: ";
    cin >> taskIndex;
    if (taskIndex > 0 && taskIndex <= tasks.size()) {
        cout << "Task '" << tasks[taskIndex - 1].name << "' deleted!" << endl;
        tasks.erase(tasks.begin() + taskIndex - 1);
    } else {
        cout << "Invalid task number!" << endl;
    }
}

// Function to mark a task as completed
void markTaskCompleted() {
    viewTasks();
    int taskIndex;
    cout << "Enter the task number to mark as completed: ";
    cin >> taskIndex;
    if (taskIndex > 0 && taskIndex <= tasks.size()) {
        tasks[taskIndex - 1].completed = true;
        cout << "Task '" << tasks[taskIndex - 1].name << "' marked as completed!" << endl;
    } else {
        cout << "Invalid task number!" << endl;
    }
}

int main() {
    int choice;
    
    while (true) {
        displayMenu();
        cout << "Choose an option: ";
        cin >> choice;
        
        switch (choice) {
            case 1:
                viewTasks();
                break;
            case 2:
                addTask();
                break;
            case 3:
                deleteTask();
                break;
            case 4:
                markTaskCompleted();
                break;
            case 5:
                cout << "Goodbye!" << endl;
                return 0;
            default:
                cout << "Invalid option! Please try again." << endl;
        }
    }

    return 0;
}
