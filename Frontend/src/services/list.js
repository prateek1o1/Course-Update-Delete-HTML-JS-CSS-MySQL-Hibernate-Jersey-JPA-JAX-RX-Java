import axios from 'axios'

// The API endpoint where login data is sent to
const listUrl = `http://localhost:9090/CourseCRUD-1.0-SNAPSHOT/api/course/list`

const list = async () => {
  const response = await axios.get(listUrl)
  return response.data
}

// Export the method as an object so that it can be accessible outside this file as a service
const exportObject = { list }
export default exportObject

