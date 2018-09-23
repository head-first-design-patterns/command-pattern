## Command Pattern

Command pattern encapsulates a request as an object, allowing us to parameterize other objects with with different types of requests.

Use case of command pattern: When you want to hide the invoker from the requests it has to perform, use command pattern

Use case of command pattern: In an event driven architecture where entire system can be restored back to a specific state (in time), command pattern can be leveraged to log all requests. Then simply rewind all the requests to get to the desired state.

Use case of command pattern: In an asynchronous, high scale system; command pattern can be used to decouple the invoker from the executioner. The invoker will push commands to the job queue for execution. The executioner will keep picking commands from the job queue for execution.  

### Key principles:

- Strive for dumb command objects. (That said, a single command object is allowed to do a lot of things when asked to execute, but you're better off following facade pattern for that.)
- Exercise caution while using lambda expressions to substitute command objects. Lambdas are used for replacing functional interfaces. Any interface with more than 1 method cannot be replaced with lambdas
- Command Pattern can be extended to go back/forth in time by maintaining a stack/queue/history of all commands and relevant actions on them



### Understanding the code

- This is a simulation of a remote control
- A remote control has multiple features like turning on/off light, fan, water heater, etc.
- The remote control should be hidden from the functions it's performing. It's job is just to take user input and delegate the action to the relevant object.
- The remote control maintains a mapping of requests to their executioners, and delegates the request when asked.

### Running the code

```
cd src/
javac RemoteControlSimulation.java
java RemoteControlSimulation

```