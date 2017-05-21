package lab8;

/**
 *  Программа моделирует обслуживание двух потоков процессов с разными параметрами  двумя центральными процессором компьютера.
 *  Для каждого потока задается своя очередь.   Процесс из каждого потока поступает на свой процессор, и лишь в том случае,
 *  когда в своей очереди нет процесса, процессор берет на обработку чужой процесс.
 *  Определить максимальный размер для каждой из очередей.
 */
public class ProcessorImitation
{
    private Core core_1;
    private Core core_2;

    public ProcessorImitation()
    {
        core_1 = new Core("Core_1");
        core_2 = new Core("Core_2");
    }

    public synchronized void giveOp(Runnable operation, int core)
    {
        if (core == 1)
        {
            if (!core_1.isBusy() || (core_1.isBusy() && core_2.isBusy()))
            {
                core_1.giveOperation(operation);
            }
            else if (!core_2.isBusy())
            {
                core_2.giveOperation(operation);
            }
        }
        else if (core == 2)
        {
            if (!core_2.isBusy() || (core_1.isBusy() && core_2.isBusy()))
            {
                core_2.giveOperation(operation);
            }
            else if (!core_1.isBusy())
            {
                core_1.giveOperation(operation);
            }
        }
    }
}
