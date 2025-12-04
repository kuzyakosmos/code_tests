package interviews.JamesPotton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Job {
        int id;
        int runtime;
        int nextId;
        Job(int id, int runtime, int nextId) {
            this.id = id;
            this.runtime = runtime;
            this.nextId = nextId;
        }
    }

    static class Chain {
        int startId;
        int lastId;
        int count;
        int totalRuntime;

        Chain(int startId, int lastId, int count, int totalRuntime) {
            this.startId = startId;
            this.lastId = lastId;
            this.count = count;
            this.totalRuntime = totalRuntime;
        }
    }

    public static void main(String[] args) {
        Map<Integer, Job> jobs = new HashMap<>();
        Set<Integer> referencedAsNext = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String header = br.readLine();
            if (header == null || !header.trim().equals("#job_id,runtime_in_seconds,next_job_id")) {
                malformed();
                return;
            }

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");

                if (parts.length != 3) malformed();
                int id, runtime, nextId;

                try {
                    id = Integer.parseInt(parts[0].trim());
                    runtime = Integer.parseInt(parts[1].trim());
                    nextId = Integer.parseInt(parts[2].trim());
                } catch (NumberFormatException e) {
                    malformed();
                    return;
                }

                if (jobs.containsKey(id)) malformed();

                jobs.put(id, new Job(id, runtime, nextId));
                if (nextId != 0) referencedAsNext.add(nextId);
            }

            if (jobs.isEmpty()) {
                malformed();
                return;
            }

            // Находим стартовые джобы
            List<Chain> chains = new ArrayList<>();
            for (Job job : jobs.values()) {
                if (!referencedAsNext.contains(job.id)) {
                    // строим цепочку
                    Set<Integer> visited = new HashSet<>();
                    int totalRuntime = 0;
                    int count = 0;
                    Job current = job;
                    int lastId = job.id;

                    while (true) {
                        if (visited.contains(current.id)) malformed(); // цикл
                        visited.add(current.id);

                        totalRuntime += current.runtime;
                        count++;
                        lastId = current.id;

                        if (current.nextId == 0) break;
                        if (!jobs.containsKey(current.nextId)) malformed();

                        current = jobs.get(current.nextId);
                    }

                    chains.add(new Chain(job.id, lastId, count, totalRuntime));
                }
            }

            if (chains.isEmpty()) malformed();

            chains.sort((a, b) -> Integer.compare(b.totalRuntime, a.totalRuntime));

            // Output
            for (Chain c : chains) {
                System.out.println("-");
                System.out.println("start_job: " + c.startId);
                System.out.println("last_job: " + c.lastId);
                System.out.println("number_of_jobs: " + c.count);
                System.out.println("job_chain_runtime: " + formatTime(c.totalRuntime));
                System.out.println("average_job_time: " + formatTime(c.totalRuntime / c.count));
            }
            System.out.println("-");

        } catch (IOException e) {
            malformed();
        }
    }

    static String formatTime(int sec) {
        int h = sec / 3600;
        sec %= 3600;
        int m = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    static void malformed() {
        System.out.println("Malformed Input");
        System.exit(0);
    }
}
