# To-Do List App in Python (Console-based)

# List to store tasks
tasks = []

# Function to display the menu
def display_menu():
    print("\nTo-Do List Menu:")
    print("1. View Tasks")
    print("2. Add Task")
    print("3. Delete Task")
    print("4. Mark Task as Completed")
    print("5. Exit")

# Function to view tasks
def view_tasks():
    if not tasks:
        print("Your to-do list is empty!")
    else:
        for index, task in enumerate(tasks, start=1):
            status = "Completed" if task['completed'] else "Pending"
            print(f"{index}. {task['name']} - {status}")

# Function to add a new task
def add_task():
    task_name = input("Enter the task description: ")
    tasks.append({'name': task_name, 'completed': False})
    print(f"Task '{task_name}' added!")

# Function to delete a task
def delete_task():
    view_tasks()
    try:
        task_index = int(input("Enter the task number to delete: ")) - 1
        if 0 <= task_index < len(tasks):
            task_name = tasks.pop(task_index)['name']
            print(f"Task '{task_name}' deleted!")
        else:
            print("Invalid task number.")
    except ValueError:
        print("Please enter a valid number.")

# Function to mark a task as completed
def mark_task_completed():
    view_tasks()
    try:
        task_index = int(input("Enter the task number to mark as completed: ")) - 1
        if 0 <= task_index < len(tasks):
            tasks[task_index]['completed'] = True
            print(f"Task '{tasks[task_index]['name']}' marked as completed!")
        else:
            print("Invalid task number.")
    except ValueError:
        print("Please enter a valid number.")

# Main function to run the To-Do List app
def main():
    while True:
        display_menu()
        try:
            choice = int(input("Choose an option: "))
            if choice == 1:
                view_tasks()
            elif choice == 2:
                add_task()
            elif choice == 3:
                delete_task()
            elif choice == 4:
                mark_task_completed()
            elif choice == 5:
                print("Goodbye!")
                break
            else:
                print("Invalid option. Please try again.")
        except ValueError:
            print("Please enter a valid number.")

# Run the program
if __name__ == "__main__":
    main()
