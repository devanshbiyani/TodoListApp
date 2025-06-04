# 📝 Todo List App

A beautiful and intuitive Android todo list application built with Kotlin. Features a modern Material Design interface with gradient backgrounds and smooth animations.

## ✨ Features

- **Add Tasks**: Easily add new tasks with the input field and add button
- **Delete Tasks**: Long-press any task to delete it
- **Task Counter**: Real-time counter showing remaining tasks
- **Empty State**: Beautiful empty state when no tasks are present
- **Modern UI**: Gradient backgrounds with card-based design
- **Toast Notifications**: Confirmation messages for user actions
- **Keyboard Support**: Press Enter to add tasks quickly

## 🎨 Design

- **Modern Material Design** with custom gradients
- **Card-based layout** for better visual hierarchy  
- **Responsive UI** that adapts to different screen sizes
- **Custom animations** and smooth transitions
- **Beautiful empty state** with motivational messaging

## 🛠️ Technical Details

### Built With
- **Language**: Kotlin
- **Platform**: Android (Native)
- **UI Framework**: Android Views
- **Architecture**: Activity-based with custom adapter

### Key Components
- `MainActivity.kt` - Main application logic and UI handling
- `TaskAdapter` - Custom ListView adapter for task items
- Custom XML layouts with gradient backgrounds
- Material Design color scheme

## 🚀 Getting Started

### Prerequisites
- Android Studio (latest version recommended)
- Android SDK (minimum API level 21)
- Kotlin support enabled

### Installation
1. Clone or download the project
2. Open in Android Studio
3. Sync project with Gradle files
4. Run the app on an emulator or physical device

### Building

# Clean and build the project
./gradlew clean build

# Install on connected device
./gradlew installDebug


## 📱 How to Use

1. **Adding Tasks**
   - Type your task in the input field
   - Tap the "+" button or press Enter
   - Task will be added to the list with a confirmation message

2. **Deleting Tasks**
   - Long-press any task in the list
   - Confirm deletion in the toast message
   - Task counter will update automatically

3. **View Progress**
   - Task counter shows remaining tasks
   - Empty state appears when all tasks are completed

## 🎯 Key Features Implementation

### Task Management
- ArrayList-based storage for task data
- Custom BaseAdapter for ListView display
- Real-time UI updates with notifyDataSetChanged()

### User Experience
- Input validation with trim() for empty tasks
- Toast notifications for user feedback
- Automatic input field clearing after task addition
- Long-press gesture for task deletion

### Visual Design
- Gradient backgrounds using XML drawables
- Card elevation and corner radius for modern look
- Custom button styling with state selectors
- Responsive layout with proper spacing

## 🔧 Customization

### Colors
Modify `res/values/colors.xml` to change the color scheme:

      <color name="primaryColor">#667eea</color>
      <color name="secondaryColor">#764ba2</color>


### Gradients
Update gradient files in `res/drawable/` to change background effects.

### Strings
Customize app text in `res/values/strings.xml` for different languages or messaging.

## 🐛 Known Issues & Solutions

### App Crashes on Task Addition
**Fixed**: Replaced `setText(getString(R.string.set_text_placeholder))` with `text.clear()` in the addTask() method.

**Happy Task Managing!** 🎉

*Built with ❤️ using Kotlin and Android Studio*
```
