import { useState } from 'react'

import loginService from './services/login'
import deleteService from './services/delete'
import updateService from './services/update'
import listService from './services/list'
import capacityService from './services/capacity'

import Notification from './components/Notification'
import LoginForm from './components/LoginForm'
import NavBar from './components/NavBar'
import Delete from './components/Delete'
import Update from './components/Update'
import List from './components/List'
import Capacity from './components/Capacity'
const App = () => {
  
  const [ user, setUser ] = useState(null)
  const [ notification, setNotification ] = useState(null)
  const [ notificationType, setNotificationType ] = useState(null)


  const notificationHandler = (message, type) => {
    setNotification(message)
    setNotificationType(type)

    setTimeout(() => {
      setNotificationType(null)
      setNotification(null)
    }, 3000)
  }

  // Function that handles login of users
  const handleLogin = async (credentials) => {
    try {
      const userObject = await loginService.login(credentials)
      setUser(userObject)
      window.localStorage.setItem('loggedInUser', JSON.stringify(userObject))

      notificationHandler(`Logged in successfully as ${userObject.email}`, 'success')
    }
    catch (exception) {
      notificationHandler(`Log in failed, check username and password entered`, 'error')
    }
    
      
  }
  const handleCourseUpdate = async (credentials) => {
    try {
      await updateService.updatecourse(credentials)
      notificationHandler(`Course Name Updated Successfully to ${credentials.updatedName}!`, 'success')
      
    }
    catch (exception) {
      notificationHandler(`Course Name Update Failed for Course${credentials.courseID}!`, 'error')
    }
  }

  const handleCapacity = async (credentials) => {
    try {
      await capacityService.updatecapacity(credentials)
      notificationHandler(`Course Capacity Updated Successfully to ${credentials.newCapacity}!`, 'success')
      
    }
    catch (exception) {
      notificationHandler(`Course Capacity Update Failed for Course${credentials.courseID}!`, 'error')
    }
  }

  const handleCourseDelete = async (credentials) => {
    try {
      await deleteService.deletecourse(credentials)  
      notificationHandler(`Course ${credentials.courseID} Deleted Successfully!`, 'success')
      
    }
    catch (exception) {
      notificationHandler(`Course ${credentials.courseID} Deletion Failed!`, 'error')
    }
  }

  const handleCourseList = async () => {
    try {
      const courseList = await listService.list()
      notificationHandler(`Courses : ${courseList}`, 'success')
      
    }
    catch (exception) {
      notificationHandler(`Courses`, 'error')
    }
  }

  return (
    <div>
      {/* Header of the page */}
      <div className='text-center page-header p-1 regular-text-shadow regular-shadow'>
          <div className='display-2 font-weight-bold'>
            Academia - Courses
            
          </div>
      </div>
     
      {/* Notification component that will render only when the notification state is not null */}
      <Notification notification={notification} type={notificationType} />
      
      
      {
        /* Show Login form when no login has happened */
        user === null && 
        <LoginForm startLogin={handleLogin}/>
   
      }
     
      {
        /* Show NavBar when login has happened */
        user !== null && 
        <NavBar user={user} setUser={setUser}/>
      } 

      {
      
        user !== null && 
        <Update update={handleCourseUpdate}/>
      }
      {<br>  
      </br>}
     {
      
      user !== null && 
      <Capacity capacity={handleCapacity}/>
    }

      {<br>  
      </br>}
      {
       
         user !== null && 
         <Delete deletes={handleCourseDelete}
         />
      }

      {<br>
      </br>}
      {    
          user !== null && 
          <List listcourse={handleCourseList}
          />
        
      }
    
    </div>
  )
}

export default App;
