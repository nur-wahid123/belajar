import { Link, router } from "@inertiajs/react";
const a = ">>"
const b = ">"
const c = "<"
const d = "<<"
const preeev = (now, prev, first) => {
    return now > 1 ? (
        <div className="m-6 btn-sm btn-group gap-2">
            <Link href={first} className="btn btn-outline">{d}</Link>
            <Link href={prev} className="btn btn-outline">{c}</Link>
            <button className="btn btn-outline">{now}</button>
        </div>
    ) : ""
}
const neext = (now, next, data, last) => {
    return now < data.last_page ? (
        <div className="m-6 btn-sm btn-group gap-2">
            <button className="btn btn-outline">{now}</button>
            <Link href={next} className="btn btn-outline">{b}</Link>
            <Link href={last} className="btn btn-outline">{a}</Link>
        </div>
    ) : ""
}

const normal = (now, next, prev, last, first, data) => {
    // console.log('halo')
    return (
        <div className="m-6 btn-sm btn-group gap-2">
            <Link href={first} className="btn btn-outline">{d}</Link>
            <Link href={prev} className="btn btn-outline">{c}</Link>
            <button className="btn btn-outline">{now}</button>
            <Link href={next} className="btn btn-outline">{b}</Link>
            <Link href={last} className="btn btn-outline">{a}</Link>
        </div>
    )
}

const Paginator = ({ data }) => {
    const now = data.meta.current_page;
    const next = data.links.next;
    const prev = data.links.prev;
    const last = data.links.last;
    const first = data.links.first;
    return data.meta.last_page > now && now > 1 ? (
        normal(now, next, prev, last, first, data)
    ) : (
        <div>
            {preeev(now, prev, first)}
            {neext(now, next, data.meta, last)}
        </div>
    )
}
export default Paginator